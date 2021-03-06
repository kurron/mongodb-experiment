package org.kurron.domain

import com.mongodb.AggregationOutput
import com.mongodb.BasicDBObject
import com.mongodb.DBObject
import groovy.util.logging.Slf4j
import org.kurron.RandomDataGenerator
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Sort
import org.springframework.data.mongodb.MongoCollectionUtils
import org.springframework.data.mongodb.core.MongoOperations
import org.springframework.data.mongodb.core.aggregation.AggregationResults
import org.springframework.data.mongodb.core.aggregation.TypedAggregation
import org.springframework.data.mongodb.core.index.Index
import org.springframework.data.mongodb.core.query.Query
import org.springframework.test.context.ContextConfiguration
import spock.lang.Ignore
import spock.lang.Specification
import org.kurron.RandomDataGenerator.*

import java.security.SecureRandom

import static org.springframework.data.mongodb.core.aggregation.Aggregation.*
import static org.springframework.data.mongodb.core.query.Criteria.where

/**
 * A learning test just to see how MongoDB might handle large amounts of data.
 */
@Slf4j
@ContextConfiguration( classes = DataPopulationLearningTestConfiguration )
class DataPopulationLearningTest extends Specification {

    private static final String[] choices = ['ONE', 'TWO', 'THREE', 'FOUR']

    private static final Random random = new SecureRandom()

    @Autowired
    MongoOperations template

    @Ignore( 'I do not want to accidentally blow away my current data set' )
    def 'import data'()
    {
        given: 'a valid MongoDB template'
        assert template != null
        DailyUserAggregateBuilder aggregateBuilder = new DailyUserAggregateBuilder()
        UserInformationBuilder userInformationBuilder = new UserInformationBuilder()

        and: 'an empty collection'
        createEmptyCollection(DailyUserAggregate)
        createEmptyCollection(UserInformation)

        and: 'a valid indexing scheme'
        template.indexOps( DailyUserAggregate ).ensureIndex( new Index().on( 'instance', Sort.Direction.ASC ).on( 'node', Sort.Direction.ASC ).on( 'organization', Sort.Direction.ASC ).on( 'date-code', Sort.Direction.ASC ).on( 'school-houses', Sort.Direction.ASC ) )
        template.indexOps( UserInformation ).ensureIndex( new Index().on( 'student-id', Sort.Direction.ASC ) )

        when: 'data is inserted into the database'
        final int NUMBER_OF_USERS = 2
        final int NUMBER_OF_YEARS = 2
        final int NUMBER_OF_DAYS = 30
        log.debug( "Creating $NUMBER_OF_USERS users" )
        1.upto( NUMBER_OF_USERS ) { student ->
            UserInformation userInformation = userInformationBuilder.build()
            template.insert( userInformation )

            DailyUserAggregate data = aggregateBuilder.build()
            data.node = randomElement( choices )
            data.organization = randomElement( choices )
            data.instance = randomElement( choices )
            data.student.code = userInformation.studentID
            data.userInformation = userInformation.id
            1.upto( NUMBER_OF_YEARS ) { year ->
                1.upto( NUMBER_OF_DAYS ) { day ->
                    data.dateCode = day + (NUMBER_OF_DAYS * (year - 1))
                    data.id = UUID.randomUUID()
                    log.debug( "Date code for year $year day $day is $data.dateCode" )
                    if ( 0 == day % 10 ) {
                        log.info( "Inserting student $student for year $year day $day into database as record $data.id" )

                    }
                    template.insert( data )
                }
            }
        }

        then: 'we should be able to count the inserted documents'
        long count = template.count( new Query( where( 'node' ).is( 'TWO' ) ), DailyUserAggregate )
        log.info "Found $count in the database"
    }

    private void createEmptyCollection(Class<?> type) {
        if (template.collectionExists(type)) {
            template.dropCollection(type)
        }
        template.createCollection(type)
    }
    @Ignore('TMP')
    def 'execute aggregation'()
    {
        given: 'a valid MongoDB template'
        assert template != null

        and: 'a valid collection'
        assert template.collectionExists( DailyUserAggregate )
        assert template.collectionExists( UserInformation )

        when: 'aggregation job is run'
        String collectionName = MongoCollectionUtils.getPreferredCollectionName( DailyUserAggregate )
        DBObject match = new BasicDBObject( '$match', new BasicDBObject( 'instance', 'ONE' ).append( 'node', 'ONE' ).append( 'organization', 'TWO' ) )
        DBObject groupFields = new BasicDBObject( '_id', '$node').append( 'totalSessionCount', new BasicDBObject( '$sum', '$student.total-lesson-session-count') )
        DBObject group = new BasicDBObject( '$group', groupFields )
        AggregationOutput aggregate = template.getCollection(collectionName).aggregate(match, group)

        then: 'we should a sum of the session counts'
        assert aggregate != null
        assert aggregate.commandResult.ok()
        log.info( aggregate.toString() )
    }

    @Ignore( 'waiting for https://jira.springsource.org/browse/DATAMONGO-741 to be fixed' )
    def 'execute learner activity report'()
    {
        given: 'a valid MongoDB template'
        assert template != null
        createEmptyCollection(DailyUserAggregate)
        createEmptyCollection(UserInformation)

        and: 'a valid indexing scheme'
        template.indexOps( DailyUserAggregate ).ensureIndex( new Index().on( 'instance', Sort.Direction.ASC ).on( 'node', Sort.Direction.ASC ).on( 'organization', Sort.Direction.ASC ).on( 'date-code', Sort.Direction.ASC ).on( 'school-houses', Sort.Direction.ASC ) )

        and: 'a known data set'
        final int NUMBER_OF_USERS = 2
        final int NUMBER_OF_YEARS = 2
        final int NUMBER_OF_DAYS = 30
        log.debug( "Creating $NUMBER_OF_USERS users" )
        DailyUserAggregateBuilder aggregateBuilder = new DailyUserAggregateBuilder()
        UserInformationBuilder userInformationBuilder = new UserInformationBuilder()
        1.upto( NUMBER_OF_USERS ) { student ->
            UserInformation userInformation = userInformationBuilder.build()
            template.insert( userInformation )

            DailyUserAggregate data = aggregateBuilder.build()
            data.node = 'ONE'
            data.organization = 'ONE'
            data.instance = 'ONE'
            data.schoolHouses = ['ONE']
            data.student.classParticipation.first().code = 'ONE'
            data.student.code = userInformation.studentID
            data.userInformation = userInformation.id
            1.upto( NUMBER_OF_YEARS ) { year ->
                1.upto( NUMBER_OF_DAYS ) { day ->
                    data.dateCode = day + (NUMBER_OF_DAYS * (year - 1))
                    data.id = UUID.randomUUID()
                    log.debug( "Date code for year $year day $day is $data.dateCode" )
                    if ( 0 == day % 10 ) {
                        log.info( "Inserting student $student for year $year day $day into database as record $data.id" )
                    }
                    template.insert( data )
                }
            }
        }

        when: 'learner activity report is run'
        // the attributes to filter on
        String INSTANCE = 'ONE'
        String NODE = 'ONE'
        String ORGANIZATION = 'ONE'
        String SCHOOL_HOUSE = 'ONE'
        String CLASS_CODE = 'ONE'
        long START_DATE = 1
        long STOP_DATE = 30

        TypedAggregation<DailyUserAggregate> aggregation = newAggregation( DailyUserAggregate,  match( where( 'instance' ).is( INSTANCE ).and( 'node' ).is( NODE ).and( 'organization' ).is( ORGANIZATION ).and( 'schoolHouses' ).is( SCHOOL_HOUSE ).and( 'student.classParticipation.code' ).is( CLASS_CODE ).and( 'dateCode' ).gte( START_DATE ).lte( STOP_DATE ) ), group( 'student.code' ).sum( 'student.totalLessonSessionCount' ).as( 'total-session-count' ) )
        AggregationResults<LearnerActivityReport> result = template.aggregate( aggregation, LearnerActivityReport )
        List<LearnerActivityReport> aggregate = result.getMappedResults()

        then: 'we should have a valid report'
        assert aggregate != null
        assert !aggregate.isEmpty()
        aggregate.each {
            log.info( it.toString() )
        }
    }

    def 'generate test Node data documents for Chris'()
    {
        given: 'a valid MongoDB template'
        assert template != null
        createEmptyCollection(NodeInformation)
        createEmptyCollection(DailyUserAggregate)
        createEmptyCollection(UserInformation)
        createEmptyCollection(ClassInformation)

        and: 'a known data set'
        final int NUMBER_OF_USERS = 5
        final int NUMBER_OF_YEARS = 5
        final int NUMBER_OF_DAYS = 30
        final int NUMBER_OF_NODES = 30
        log.debug("Creating $NUMBER_OF_NODES nodes")
        log.debug("Creating $NUMBER_OF_USERS users")
        DailyUserAggregateBuilder aggregateBuilder = new DailyUserAggregateBuilder()
        UserInformationBuilder userInformationBuilder = new UserInformationBuilder()
        ClassInformationBuilder classInformationBuilder = new ClassInformationBuilder()
        NodeInformationBuilder nodeInformationBuilder = new NodeInformationBuilder()
        final RandomDataGenerator generator = new RandomDataGenerator()

        def courses = []
        10.times{
            courses << classInformationBuilder.build()
        }
         courses.each{
             template.insert( it )
         }

        def nodes = []

        def nodeNames = []

        1.upto( NUMBER_OF_NODES ){
            nodes << nodeInformationBuilder.build()
         }

        nodes.each{
            it.instance = "one"
            nodeNames << it.nickname
            template.insert( it )
        }

        1.upto( NUMBER_OF_USERS ){ student ->
            UserInformation userInformation = userInformationBuilder.build()
            userInformation.instance = 'ONE'
            userInformation.node = generator.randomValue( nodeNames )
            userInformation.organization = 'ONE'
            userInformation.tags = ['ONE', 'TWO', 'THREE']
            userInformation.isActive = true
            template.insert( userInformation )

            DailyUserAggregate data = aggregateBuilder.build()
            data.node = userInformation.node
            data.organization = userInformation.organization
            data.instance = userInformation.instance
            data.schoolHouses = ['ONE']
            data.tags = userInformation.tags
            data.student.classParticipation.first().code = 'ONE'
            data.student.code = userInformation.studentID
            data.student.classParticipation.each {
                it.classInformation = courses[random.nextInt(courses.size())].id
            }
            data.userInformation = userInformation.id
            1.upto( NUMBER_OF_YEARS ) { year ->
                1.upto( NUMBER_OF_DAYS ) { day ->
                    data.dateCode = day + (NUMBER_OF_DAYS * (year - 1))
                    data.id = UUID.randomUUID()
                    log.debug( "Date code for year $year day $day is $data.dateCode" )
                    if ( 0 == day % 10 ) {
                        log.info( "Inserting student $student for year $year day $day into database as record $data.id" )
                    }
                    template.insert( data )
                }
            }
        }

        when: 'nothing interesting is done'

        then: 'we have a populated database'
        true

    }
    @Ignore('TMP')
    def 'generate test data for Ron'()
    {
        given: 'a valid MongoDB template'
        assert template != null
        createEmptyCollection(DailyUserAggregate)
        createEmptyCollection(UserInformation)
        createEmptyCollection(ClassInformation)

        and: 'a known data set'
        final int NUMBER_OF_USERS = 2
        final int NUMBER_OF_YEARS = 2
        final int NUMBER_OF_DAYS = 30
        log.debug( "Creating $NUMBER_OF_USERS users" )
        DailyUserAggregateBuilder aggregateBuilder = new DailyUserAggregateBuilder()
        UserInformationBuilder userInformationBuilder = new UserInformationBuilder()
        ClassInformationBuilder classInformationBuilder = new ClassInformationBuilder()

        def courses = []
        10.times {
            courses << classInformationBuilder.build()
        }
        courses.each {
            template.insert( it )
        }

        1.upto( NUMBER_OF_USERS ) { student ->
            UserInformation userInformation = userInformationBuilder.build()
            userInformation.instance = 'ONE'
            userInformation.node = 'ONE'
            userInformation.organization = 'ONE'
            userInformation.tags = ['ONE', 'TWO', 'THREE']
            userInformation.isActive = true
            template.insert( userInformation )

            DailyUserAggregate data = aggregateBuilder.build()
            data.node = 'ONE'
            data.organization = 'ONE'
            data.instance = 'ONE'
            data.schoolHouses = ['ONE']
            data.tags = [ 'ONE', 'TWO', 'THREE' ]
            data.student.classParticipation.first().code = 'ONE'
            data.student.code = userInformation.studentID
            data.student.classParticipation.each {
                it.classInformation = courses[random.nextInt(courses.size())].id
            }
            data.userInformation = userInformation.id
            1.upto( NUMBER_OF_YEARS ) { year ->
                1.upto( NUMBER_OF_DAYS ) { day ->
                    data.dateCode = day + (NUMBER_OF_DAYS * (year - 1))
                    data.id = UUID.randomUUID()
                    log.debug( "Date code for year $year day $day is $data.dateCode" )
                    if ( 0 == day % 10 ) {
                        log.info( "Inserting student $student for year $year day $day into database as record $data.id" )
                    }
                    template.insert( data )
                }
            }
        }

        when: 'nothing interesting is done'

        then: 'we have a populated database'
        true
    }

    String randomElement( String [] collection ) {
          collection[random.nextInt( collection.size())]
    }
    @Ignore('TMP')
    def 'generate test data for MSal'()
    {
        given: 'a valid MongoDB template'
        assert template != null
        createEmptyCollection(DailyUserAggregate)

        and: 'a known data set'
        final int NUMBER_OF_USERS = 5
        final int NUMBER_OF_YEARS = 2
        final int NUMBER_OF_DAYS = 30
        log.debug( "Creating $NUMBER_OF_USERS users" )
        DailyUserAggregateBuilder aggregateBuilder = new DailyUserAggregateBuilder()

        1.upto( NUMBER_OF_USERS ) { student ->
            DailyUserAggregate data = aggregateBuilder.build()
            data.node = 'ONE'
            data.organization = 'ONE'
            data.instance = 'ONE'
            data.schoolHouses = ['ONE']
            data.tags = [ 'ONE', 'TWO', 'THREE' ]
            data.student.classParticipation.first().code = 'ONE'
            data.instructor.instructorID = "TEACHER.$student"
            log.info( "User with instructor ID of $data.instructor.instructorID created" )
            1.upto( NUMBER_OF_YEARS ) { year ->
                1.upto( NUMBER_OF_DAYS ) { day ->
                    data.dateCode = day + (NUMBER_OF_DAYS * (year - 1))
                    data.id = UUID.randomUUID()
                    log.debug( "Date code for year $year day $day is $data.dateCode" )
                    if ( 0 == day % 10 ) {
                        log.info( "Inserting student $student for year $year day $day into database as record $data.id" )
                    }
                    template.insert( data )
                }
            }
        }

        when: 'nothing interesting is done'

        then: 'we have a populated database'
        true
    }
}

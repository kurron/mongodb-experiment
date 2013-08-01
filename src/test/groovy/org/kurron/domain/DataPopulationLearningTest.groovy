package org.kurron.domain

import com.mongodb.AggregationOutput
import com.mongodb.BasicDBObject
import com.mongodb.CommandResult
import com.mongodb.DBObject
import groovy.util.logging.Slf4j
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Sort
import org.springframework.data.mongodb.MongoCollectionUtils
import org.springframework.data.mongodb.core.MongoOperations
import org.springframework.data.mongodb.core.index.Index
import org.springframework.data.mongodb.core.query.Query
import org.springframework.test.context.ContextConfiguration
import spock.lang.Ignore
import spock.lang.Specification

import java.security.SecureRandom

import static org.springframework.data.mongodb.core.query.Criteria.*

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
        DailyUserAggregateBuilder builder = new DailyUserAggregateBuilder()

        and: 'an empty collection'
        if ( template.collectionExists( DailyUserAggregate ) ) {
            template.dropCollection( DailyUserAggregate )
        }
        template.createCollection( DailyUserAggregate )

        and: 'a valid indexing scheme'
        template.indexOps( DailyUserAggregate ).ensureIndex( new Index().on( 'instance', Sort.Direction.ASC ).on( 'node', Sort.Direction.ASC ).on( 'organization', Sort.Direction.ASC ).on( 'date-code', Sort.Direction.ASC ) )

        when: 'data is inserted into the database'
        final int NUMBER_OF_USERS = 100
        final int NUMBER_OF_YEARS = 10
        final int NUMBER_OF_DAYS = 365
        log.debug( "Creating $NUMBER_OF_USERS users" )
        1.upto( NUMBER_OF_USERS ) { student ->
            DailyUserAggregate data = builder.build()
            data.node = randomElement( choices )
            data.organization = randomElement( choices )
            data.instance = randomElement( choices )
            data.student.totalLessonSessionCount = 1
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

    def 'execute aggregation'()
    {
        given: 'a valid MongoDB template'
        assert template != null

        and: 'a valid collection'
        assert template.collectionExists( DailyUserAggregate )

        when: 'aggregation job is run'
        String collectionName = MongoCollectionUtils.getPreferredCollectionName( DailyUserAggregate )
        DBObject match = new BasicDBObject( '$match', new BasicDBObject( 'instance', 'ONE' ).append( 'node', 'ONE' ).append( 'organization', 'TWO' ) )
        DBObject groupFields = new BasicDBObject( '_id', '$node').append( 'totalSessionCount', new BasicDBObject( '$sum', '$student.totalLessonSessionCount') )
        DBObject group = new BasicDBObject( '$group', groupFields )
        AggregationOutput aggregate = template.getCollection(collectionName).aggregate(match, group)

        then: 'we should a sum of the session counts'
        assert aggregate != null
        assert aggregate.commandResult.ok()
        log.info( aggregate.toString() )
    }

    String randomElement( String [] collection ) {
          collection[random.nextInt( collection.size())]
    }
}

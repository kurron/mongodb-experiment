package org.kurron.domain

import groovy.util.logging.Slf4j
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.mongodb.core.MongoOperations
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

        when: 'data is inserted into the database'
        final int NUMBER_OF_USERS = 2
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

    String randomElement( String [] collection ) {
          collection[random.nextInt( collection.size())]
    }
}

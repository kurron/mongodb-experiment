package org.kurron.domain

import groovy.util.logging.Slf4j
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.mongodb.core.MongoOperations
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification

/**
 * A learning test just to see how MongoDB might handle large amounts of data.
 */
@Slf4j
@ContextConfiguration( classes = DataPopulationLearningTestConfiguration )
class DataPopulationLearningTest extends Specification {
    @Autowired
    MongoOperations template

    def 'import data'()
    {
        given: 'a valid MongoDB template'
        assert template != null
        DailyUserAggregateBuilder builder = new DailyUserAggregateBuilder()

        when: 'an object is inserted into the database'
        if ( template.collectionExists( DailyUserAggregate ) ) {
            template.dropCollection( DailyUserAggregate )
        }
        template.createCollection( DailyUserAggregate )

        final int NUMBER_OF_USERS = 1
        final int NUMBER_OF_YEARS = 2
        final int NUMBER_OF_DAYS = 365
        log.debug( "Creating $NUMBER_OF_USERS users" )
        1.upto( NUMBER_OF_USERS ) {
            log.debug( "Creating $NUMBER_OF_YEARS years" )
            DailyUserAggregate data = builder.build()
            data.student.totalLessonSessionCount = 1
            1.upto( NUMBER_OF_YEARS ) { year ->
                log.debug( "Creating $NUMBER_OF_DAYS days" )
                1.upto( NUMBER_OF_DAYS ) { day ->
                    data.dateCode = day + (NUMBER_OF_DAYS * (year - 1))
                    data.id = UUID.randomUUID()
                    log.debug( "Date code for year $year day $day is $data.dateCode" )
                    log.info( "Inserting student $data.student.studentID for day $data.dateCode into database as record $data.id" )
                    template.insert( data )
                }
            }
        }

        then: 'we should find it'
        List<DailyUserAggregate> results = template.findAll( DailyUserAggregate )
        assert !results.empty
        log.debug "Found $results.size in the database"

/*
        results.each {
            log.debug( it.toString() )
        }
*/
        true
    }
}

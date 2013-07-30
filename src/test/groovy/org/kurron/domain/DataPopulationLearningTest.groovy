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

        1.upto( 100000 ) {
            log.debug( "Inserting $it" )
            template.insert( builder.build() )
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

package org.kurron.domain

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.mongodb.core.MongoOperations
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification

/**
 * A learning test just to see how MongoDB might handle large amounts of data.
 */
@ContextConfiguration( classes = DataPopulationLearningTestConfiguration )
class DataPopulationLearningTest extends Specification {
    @Autowired
    MongoOperations mongoOperations

    def 'import data'()
    {
        given: 'a valid MongoDB template'
        assert mongoOperations != null
        DailyUserAggregateBuilder builder = new DailyUserAggregateBuilder()

        when: 'an object is inserted into the database'
        if ( mongoOperations.collectionExists( DailyUserAggregate ) ) {
            mongoOperations.dropCollection( DailyUserAggregate )
        }
        mongoOperations.createCollection( DailyUserAggregate )
        DailyUserAggregate aggregate = builder.build()
        mongoOperations.insert( aggregate )

        then: 'we should find it'
        List<DailyUserAggregate> results = mongoOperations.findAll( DailyUserAggregate )
        assert !results.empty
        println "Found $results.size in the database"

        results.each {
            println it
        }
        true
    }
}

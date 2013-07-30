package org.kurron.domain

import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification

/**
 * A learning test just to see how MongoDB might handle large amounts of data.
 */
@ContextConfiguration( locations = ['classpath:/org/kurron/domain/DataPopulationLearningTest-context.xml'] )
class DataPopulationLearningTest extends Specification {
    def 'import data'()
    {
        given: 'a JSON serializer'

        when: 'an object is serialized into JSON'

        then: 'printout JSON'
        true
    }
}

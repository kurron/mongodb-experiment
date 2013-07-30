package org.kurron.domain

import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.ImportResource

/**
 * Spring context for the learning test.
 */
@Configuration
@ImportResource( 'classpath:/org/kurron/domain/DataPopulationLearningTest-context.xml' )
class DataPopulationLearningTestConfiguration {
}

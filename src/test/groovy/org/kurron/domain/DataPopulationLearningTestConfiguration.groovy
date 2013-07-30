package org.kurron.domain

import com.mongodb.Mongo
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.ImportResource
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor
import org.springframework.data.mongodb.core.MongoFactoryBean
import org.springframework.data.mongodb.core.MongoOperations
import org.springframework.data.mongodb.core.MongoTemplate

/**
 * Spring context for the learning test.
 */
@SuppressWarnings("GrMethodMayBeStatic")
@Configuration
@ImportResource( 'classpath:/org/kurron/domain/DataPopulationLearningTest-context.xml' )
class DataPopulationLearningTestConfiguration {
    public @Bean MongoOperations mongoTemplate(Mongo mongo) {
        new MongoTemplate( mongo, 'test' )
    }

    public @Bean MongoFactoryBean mongo() {
        MongoFactoryBean mongo = new MongoFactoryBean();
        mongo.host = 'mongo-secondary'
        return mongo
    }

    public @Bean PersistenceExceptionTranslationPostProcessor persistenceExceptionTranslationPostProcessor() {
        new PersistenceExceptionTranslationPostProcessor()
    }
}

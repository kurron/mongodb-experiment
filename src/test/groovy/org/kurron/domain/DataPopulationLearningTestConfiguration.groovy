package org.kurron.domain

import com.mongodb.Mongo
import com.mongodb.WriteConcern
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.ImportResource
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor
import org.springframework.data.mongodb.core.MongoFactoryBean
import org.springframework.data.mongodb.core.MongoOperations
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.data.mongodb.core.WriteResultChecking

/**
 * Spring context for the learning test.
 */
@SuppressWarnings("GrMethodMayBeStatic")
@Configuration
@ImportResource( 'classpath:/org/kurron/domain/DataPopulationLearningTest-context.xml' )
class DataPopulationLearningTestConfiguration {
    public @Bean MongoOperations mongoTemplate(Mongo mongo) {
        MongoTemplate template = new MongoTemplate(mongo, 'test')
        template.writeResultChecking = WriteResultChecking.EXCEPTION
        //template.writeConcern = WriteConcern.JOURNALED
        template
    }

    public @Bean MongoFactoryBean mongo() {
        MongoFactoryBean mongo = new MongoFactoryBean();
        mongo.host = 'mongo'
        return mongo
    }

    public @Bean PersistenceExceptionTranslationPostProcessor persistenceExceptionTranslationPostProcessor() {
        new PersistenceExceptionTranslationPostProcessor()
    }

    public @Bean DailyUserAggregateEventListener dailyUserAggregateEventListener() {
        new DailyUserAggregateEventListener()
    }
}

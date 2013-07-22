package org.kurron.domain

import org.kurron.domain.DailyUserAggregate

/**
 * Convenience object builder.
 */
class DailyUserAggregateBuilder {
    /**
     * Generates random data.
     */
    private final RandomDataGenerator generator = new RandomDataGenerator()

    DailyUserAggregate build() {
        DailyUserAggregate aggregate = new DailyUserAggregate()
        aggregate.id = generator.randomObjectId()
        aggregate.dailyAggregateId = generator.randomObjectId()
        aggregate.username = generator.randomHexString()
        aggregate.node = generator.randomHexString()
        aggregate.organization = generator.randomHexString()
        2.times {
            aggregate.tags << generator.randomHexString()
        }
        aggregate.newClassRegistrationCount = generator.randomNumberExclusive( 10 )
        aggregate.totalLessonSessionCount = generator.randomNumberExclusive( 10 )
        2.times {
            aggregate.languagesAccessed << generator.randomHexString()
        }
        aggregate.sustainment.learnedItemCount = generator.randomNumberExclusive( 10 )
        aggregate.sustainment.staleItemCount = generator.randomNumberExclusive( 100 )
        aggregate.sustainment.totalRefreshmentTime = generator.randomNumberExclusive( 100 )

        aggregate
    }
}

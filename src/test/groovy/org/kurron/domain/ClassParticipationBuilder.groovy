package org.kurron.domain

import org.kurron.RandomDataGenerator

/**
 * Convenience object builder.
 */
class ClassParticipationBuilder {
    /**
     * Generates random data.
     */
    private final RandomDataGenerator generator = new RandomDataGenerator()

    ClassParticipation build() {
        ClassParticipation classParticipation = new ClassParticipation()
        classParticipation.enrolledToday = generator.randomBoolean()
        classParticipation.totalLearningTime = generator.randomNumberExclusive( 10 )
        classParticipation.code = generator.randomHexString()
        classParticipation
    }
}

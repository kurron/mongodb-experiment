package org.kurron.domain

import org.kurron.RandomDataGenerator

/**
 * Convenience object builder.
 */
class ClassInformationBuilder {
    /**
     * Generates random data.
     */
    private final RandomDataGenerator generator = new RandomDataGenerator()

    ClassInformation build() {
        ClassInformation user = new ClassInformation()
        user.id = generator.randomObjectId()
        user.title = generator.randomHexString()
        user.code = generator.randomHexString()
        2.times {
            user.instructors << 'TEACHER.' + generator.randomHexString()
        }
        user.schoolHouse = generator.randomHexString()
        user
    }
}

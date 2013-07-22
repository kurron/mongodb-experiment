package org.kurron.domain

import org.kurron.domain.ClassInformation

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
        user.instructors << 'TEACHER.' + generator.randomHexString()
        user
    }
}

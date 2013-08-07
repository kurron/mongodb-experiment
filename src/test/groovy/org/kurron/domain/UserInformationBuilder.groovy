package org.kurron.domain

import org.joda.time.DateTime
import org.kurron.RandomDataGenerator

/**
 * Convenience object builder.
 */
class UserInformationBuilder {
    /**
     * Generates random data.
     */
    private final RandomDataGenerator generator = new RandomDataGenerator()

    UserInformation build() {
        DateTime now = new DateTime()
        UserInformation user = new UserInformation()
        user.id = generator.randomObjectId()
        user.instance = generator.randomHexString()
        user.node = generator.randomHexString()
        user.organization = generator.randomHexString()
        user.tags = [ generator.randomHexString(), generator.randomHexString()]
        user.isActive = generator.randomBoolean()
        user.dateCreated = now.minusDays( 240 ).millis
        user.dateDeleted = now.millis
        user.studentID = generator.randomHexString()
        user.instructorID = generator.randomHexString()
        user.administratorID = generator.randomHexString()
        user.email = generator.randomEMail()
        user.lastLogInAsStudent = now.minusDays( 60 ).millis
        user.lastLogInAsInstructor = now.minusDays( 90 ).millis
        user.lastLogInAsAdministrator = now.minusDays( 120 ).millis
        user
    }
}

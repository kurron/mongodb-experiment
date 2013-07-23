package org.kurron.domain
/**
 * Convenience object builder.
 */
class UserInformationBuilder {
    /**
     * Generates random data.
     */
    private final RandomDataGenerator generator = new RandomDataGenerator()

    UserInformation build() {
        UserInformation user = new UserInformation()
        user.id = generator.randomObjectId()
        user.instance = generator.randomInstance()
        user.isActive = generator.randomBoolean()
        user.dateCreated = generator.randomLong()
        user.dateDeleted = generator.randomLong()
        user.studentID = generator.randomHexString()
        user.instructorID = generator.randomHexString()
        user.administratorID = generator.randomHexString()
        user.email = generator.randomEMail()
        user.lastLogInAsStudent = generator.randomLong()
        user.lastLogInAsInstructor = generator.randomLong()
        user.lastLogInAsAdministrator = generator.randomLong()
        user
    }
}

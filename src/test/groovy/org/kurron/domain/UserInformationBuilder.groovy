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
        user.username = generator.randomHexString()
        user.email = generator.randomEMail()
        user.lastLogIn = generator.randomLong()
        user.instructorFlag = generator.randomBoolean()
        user
    }
}

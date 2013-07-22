import org.kurron.domain.User

/**
 * Convenience object builder.
 */
class UserBuilder {
    /**
     * Generates random data.
     */
    private final RandomDataGenerator generator = new RandomDataGenerator()

    User build() {
        User user = new User()
        user.id = generator.randomObjectId()
        user.username = generator.randomHexString()
        user.email = generator.randomEMail()
        user.lastLogIn = generator.randomLong()
        user
    }
}

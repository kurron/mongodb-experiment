import java.security.SecureRandom

/**
 * Generates random data suitable for testing scenarios.
 */
class RadomDataGenerator {
    /**
     * Generates random data.
     */
    private final SecureRandom generator = new SecureRandom()

    /**
     * Generates a random long from 0 to Long.MAX_VALUE.
     * @return randomized long.
     */
    public Long randomLong() {
        Math.abs( generator.nextLong() )
    }

    String randomObjectId() {
        UUID.randomUUID().toString().toUpperCase()
    }
}

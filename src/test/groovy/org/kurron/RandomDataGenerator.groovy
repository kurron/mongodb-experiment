package org.kurron

import java.security.SecureRandom

/**
 * Generates random data suitable for testing scenarios.
 */
public class RandomDataGenerator {

    /**
     * Legal hex characters.
     */
    private final char[] theCharacters = ['A', 'B', 'C', 'D', 'E', 'F', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9']


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

    /**
     * Randomized object id.
     * @return random object id.
     */
    String randomObjectId() {
        UUID.randomUUID().toString().toUpperCase()
    }

    /**
     * Randomized object instance.
     * @return random object instance
     */
    String randomInstance() {
        UUID.randomUUID().toString().toUpperCase()
    }

    /**
     * Generates an 8 character string of randomized hex values.
     * @return random string.
     */
    String randomHexString() {
        randomHexString( 8 )
    }

    String randomEMail() {
        randomHexString() + '@gmail.com'
    }

    /**
     * Generates a random hex string of the specified length.
     * @param length how long to make the string.
     * @return the string.
     */
    public String randomHexString( final int length )
    {
        final StringBuilder builder = new StringBuilder( length )
        for( int i = 0; i < length; i++ )
        {
            builder.append( theCharacters[randomArrayIndex( theCharacters.length )] )
        }
        builder.toString()
    }

    /**
     * Generates a random number between 0 and N, exclusive, which is suitable for array indexing.
     * @param arrayLength the size of the array.
     * @return random index.
     */
    public int randomArrayIndex( final int arrayLength )
    {
        return randomNumberExclusive( arrayLength )
    }

    /**
     * Generates a random integer from 0 up to, but not inclusive, of the specified max value.
     * @param maxValue top of the number range.
     * @return random number.
     */
    public int randomNumberExclusive( final int maxValue )
    {
        return generator.nextInt( maxValue )
    }

    /**
     * Generates a random boolean value.
     * @return true or false.
     */
    public boolean randomBoolean()
    {
        return generator.nextBoolean()
    }
}

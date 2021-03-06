package org.kurron

import org.joda.time.DateTime

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
     * Legal platforms
     */
    private final ArrayList platforms = ['web', 'desktop', 'mobile']

    /**
     * Legal asset types
     */
    private final ArrayList assetTypes = ['list', 'unit']

    /**
     * Legal Node Statuses
     */
    private final ArrayList nodeStatus = ['trial', 'active', 'inactive']

    /**
     * Legal Node Types
     */
    private final ArrayList nodeTypes = ['Public Library', 'University Library', 'Company', 'Government Agency', 'Language Lab', 'K-12 School', 'Other']

    /**
     * Legal Course Statuses
     */
    private final ArrayList courseStatuses = ['inprogress', 'complete']

    /**
     * Legal Known Languages
     */
    private final ArrayList knownLanguages = ['ENGLISH', 'ARABIC']

    /**
     * Legal Learning Languages
     */
    private final ArrayList learningLanguages = ['SPANISH', 'FRENCH', 'GERMAN']

    /**
     * Legal Content Types
     */
    private final ArrayList contentTypes = ['List', 'Unit']

    /**
     * Generates a random Legal Content Type
     * @return a random legal Content Type
     */
    public String randomContentType(){
        return contentTypes[randomArrayIndex( contentTypes.size() )]
    }

    /**
     * Generates a random Legal Learning Language Code
     * @return a Legal Learning Language Code
     */
    public String randomLearningLanguage(){
        return learningLanguages[randomArrayIndex( learningLanguages.size() )]
    }

    /**
     * Generates a random Legal Known Language Code
     * @return Legal Known Language Code
     */
    public String randomKnownLanguage(){
        return knownLanguages[randomArrayIndex( knownLanguages.size() )]
    }

    /**
     * Generates a random valid course status
     * @return a random valid course type
     */
    public String randomCourseStatus(){
        return courseStatuses[randomArrayIndex( courseStatuses.size() )]
    }

    /**
     * Generates a random valid Node Type
     * @return a random string from nodeTypes
     */
    public String randomNodeType(){
        return nodeTypes[randomArrayIndex( nodeTypes.size() )]
    }

    /**
     * Generates a random valid node status
     * @return a random string from nodeStatus
     */
    public String randomNodeStatus(){
        return nodeStatus[randomArrayIndex( nodeStatus.size() )]
    }

    /**
     * Generates a random valid platform
     * @return a random string from platforms
     */
    public String randomPlatform(){
        return platforms[randomArrayIndex( platforms.size() )]
    }

    /**
     * Returns a random value from the passed in array
     * @return a random value from inputted array
     */
    public randomValue( final ArrayList value){
        return value[randomArrayIndex( value.size() )]
    }

    /**
     * Generates a random valid platform
     * @return a random string from platforms
     */
    public String randomAssetType(){
        return assetTypes[randomArrayIndex( assetTypes.size() )]
    }

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
     * Generates a random integer from 1 up to and including the specified max value.
     * @param maxValue top of the number range.
     * @return random number.
     */
    public int randomNumberInclusive( final int maxValue )
    {
        return generator.nextInt( maxValue ) + 1
    }

    /**
     * Generates a random boolean value.
     * @return true or false.
     */
    public boolean randomBoolean()
    {
        return generator.nextBoolean()
    }

    /**
     * Generates a Random date
     * @returns a random date
     */
    public Date randomDate( final int Value)
    {
        DateTime now = new DateTime()
        return  now.minusDays( Value ).toDate()
    }

    /**
     * Generates a random legal Phone Number
     * return phone number < XXX-XXX-XXXX >
     */
    public String randomPhoneNumber ()
    {
        Random rand = new Random()
        int max = 10
        def numbList = []
        (1..10).each {
            numbList << rand.nextInt( max ).toString()
        }
        return numbList[0] + numbList[1] + numbList[2] + "-" +  numbList[3] + numbList[4] + numbList[5] + "-" + numbList[6] + numbList[7] + numbList[8] + numbList[9]
    }
}

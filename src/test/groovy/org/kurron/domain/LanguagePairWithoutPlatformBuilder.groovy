package org.kurron.domain

import org.kurron.RandomDataGenerator

/**
 * Created with IntelliJ IDEA.
 * User: vagrant
 * Date: 8/21/13
 * Time: 2:58 PM
 * To change this template use File | Settings | File Templates.
 */
class LanguagePairWithoutPlatformBuilder {
    private final RandomDataGenerator generator = new RandomDataGenerator()

    LanguagePairWithoutPlatform build(){
        LanguagePairWithoutPlatform pair = new LanguagePairWithoutPlatform()
        pair.knownCode = generator.randomKnownLanguage()
        pair.learningCode = generator.randomLearningLanguage()
        pair.sessionCount = generator.randomNumberExclusive( 10 )
        pair.sessionTime = pair.sessionCount // one-minute sessions
        pair
    }
}

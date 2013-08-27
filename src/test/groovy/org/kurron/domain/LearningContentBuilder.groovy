package org.kurron.domain

import org.kurron.RandomDataGenerator

/**
 * Created with IntelliJ IDEA.
 * User: vagrant
 * Date: 8/21/13
 * Time: 3:07 PM
 * To change this template use File | Settings | File Templates.
 */
class LearningContentBuilder {
    private final RandomDataGenerator generator = new RandomDataGenerator()
    private final LanguagePairWithoutPlatformBuilder languagePair = new LanguagePairWithoutPlatformBuilder()

    LearningContent build() {
        LearningContent content = new LearningContent()
        content.type = generator.randomContentType()
        content.title = generator.randomHexString()
        content.status = generator.randomCourseStatus()
        content.pair = languagePair.build()
        content
    }
}

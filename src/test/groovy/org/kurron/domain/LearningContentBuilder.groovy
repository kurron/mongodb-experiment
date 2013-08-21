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
    private final LanguagePairBuilder languagePair = new LanguagePairBuilder()

    LearningContent build() {
        LearningContent content = new LearningContent()
        content.type = generator.randomContentType()
        content.pair = languagePair.build()
        content
    }
}

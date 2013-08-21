package org.kurron.domain

import org.kurron.RandomDataGenerator

/**
 * Created with IntelliJ IDEA.
 * User: vagrant
 * Date: 8/21/13
 * Time: 2:29 PM
 * To change this template use File | Settings | File Templates.
 */
class CourseProgressBuilder {
    private final RandomDataGenerator generator = new RandomDataGenerator()
    private final LanguagePairBuilder languagePair = new LanguagePairBuilder()

    CourseProgress build() {
        CourseProgress courseProgress = new CourseProgress()
        courseProgress.courseStatus = generator.randomCourseStatus()
        courseProgress.pair = languagePair.build()
    }
}
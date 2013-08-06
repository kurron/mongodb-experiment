package org.kurron.domain

import org.kurron.RandomDataGenerator

/**
 * Convenience object builder.
 */
class DailyUserAggregateBuilder {
    /**
     * Generates random data.
     */
    private final RandomDataGenerator generator = new RandomDataGenerator()

    private final knownLanguageListing = ['ENGLISH', 'ARABIC']

    private final learningLanguageListing = ['SPANISH', 'FRENCH', 'GERMAN']

    DailyUserAggregate build() {
        DailyUserAggregate aggregate = new DailyUserAggregate()
        aggregate.id = generator.randomObjectId()
        aggregate.instance = generator.randomInstance()
        aggregate.dateCode = generator.randomLong()
        aggregate.node = generator.randomHexString()
        aggregate.organization = generator.randomHexString()
        2.times {
            aggregate.schoolHouses << generator.randomHexString()
        }
        2.times {
            aggregate.tags << generator.randomHexString()
        }

        aggregate.student.code = generator.randomHexString()
        aggregate.student.totalLessonSessionCount = generator.randomNumberExclusive( 10 )
        aggregate.student.sustainment.learnedItemCount = generator.randomNumberExclusive( 10 )
        aggregate.student.sustainment.staleItemCount = generator.randomNumberExclusive( 100 )
        aggregate.student.sustainment.totalRefreshmentTime = generator.randomNumberExclusive( 100 )

        aggregate.student.mobileData.downloadedListCount = generator.randomNumberExclusive( 10 )
        aggregate.student.mobileData.downloadedCourseCountCount = generator.randomNumberExclusive( 10 )
        aggregate.student.mobileData.sessionCount = generator.randomNumberExclusive( 10 )
        aggregate.student.mobileData.sessionTime = generator.randomNumberExclusive( 100 )

        aggregate.student.desktopData.downloadedListCount = generator.randomNumberExclusive( 10 )
        aggregate.student.desktopData.downloadedCourseCountCount = generator.randomNumberExclusive( 10 )
        aggregate.student.desktopData.sessionCount = generator.randomNumberExclusive( 10 )
        aggregate.student.desktopData.sessionTime = generator.randomNumberExclusive( 100 )

        aggregate.student.webData.downloadedListCount = generator.randomNumberExclusive( 10 )
        aggregate.student.webData.downloadedCourseCountCount = generator.randomNumberExclusive( 10 )
        aggregate.student.webData.sessionCount = generator.randomNumberExclusive( 10 )
        aggregate.student.webData.sessionTime = generator.randomNumberExclusive( 100 )

        2.times {
            LanguagePair pair = new LanguagePair()
            pair.knownCode = knownLanguageListing[ generator.randomArrayIndex( knownLanguageListing.size() ) ]
            pair.learningCode = learningLanguageListing[ generator.randomArrayIndex( knownLanguageListing.size() ) ]
            pair.sessionCount = generator.randomNumberExclusive( 10 )
            aggregate.student.mobileData.languagesAccessed << pair
        }

        2.times {
            LanguagePair pair = new LanguagePair()
            pair.knownCode = knownLanguageListing[ generator.randomArrayIndex( knownLanguageListing.size() ) ]
            pair.learningCode = learningLanguageListing[ generator.randomArrayIndex( knownLanguageListing.size() ) ]
            pair.sessionCount = generator.randomNumberExclusive( 10 )
            aggregate.student.desktopData.languagesAccessed << pair
        }

        2.times {
            LanguagePair pair = new LanguagePair()
            pair.knownCode = knownLanguageListing[ generator.randomArrayIndex( knownLanguageListing.size() ) ]
            pair.learningCode = learningLanguageListing[ generator.randomArrayIndex( knownLanguageListing.size() ) ]
            pair.sessionCount = generator.randomNumberExclusive( 10 )
            aggregate.student.webData.languagesAccessed << pair
        }

        4.times {
            LearningContent content = new LearningContent()
            content.type = generator.randomBoolean() ? 'List' : 'Unit'
            content.title = generator.randomHexString()
            LanguagePair pair = new LanguagePair()
            pair.knownCode = knownLanguageListing[ generator.randomArrayIndex( knownLanguageListing.size() ) ]
            pair.learningCode = learningLanguageListing[ generator.randomArrayIndex( knownLanguageListing.size() ) ]
            pair.sessionCount = generator.randomNumberExclusive( 10 )
            content.pair = pair
            aggregate.student.learningContent << content
        }
        3.times {
            ClassParticipation participation = new ClassParticipation()
            participation.code = generator.randomHexString()
            participation.totalLearningTime = generator.randomNumberExclusive( 100 )
            participation.enrolledToday = generator.randomBoolean()
            aggregate.student.classParticipation << participation
        }

        aggregate.instructor.instructorID = 'TEACHER.' + generator.randomHexString()
        aggregate.instructor.totalReportsGeneratedCount = generator.randomNumberExclusive( 10 )
        aggregate.instructor.totalAssignmentsGeneratedCount = generator.randomNumberExclusive( 10 )
        aggregate.instructor.totalListsPublishedCount = generator.randomNumberExclusive( 10 )
        aggregate.instructor.totalClassesCreatedCount = generator.randomNumberExclusive( 10 )
        aggregate.instructor.totalInstructorPortalSessionCount = generator.randomNumberExclusive( 10 )
        aggregate.instructor.totalInstructorPortalSessionTime = generator.randomNumberExclusive( 100 )

        aggregate.administrator.administratorID = generator.randomHexString()
        aggregate.administrator.totalReportsGeneratedCount = generator.randomNumberExclusive( 10 )
        aggregate.administrator.totalPortalSessionCount = generator.randomNumberExclusive( 10 )
        aggregate.administrator.totalPortalSessionTime = generator.randomNumberExclusive( 100 )


        aggregate
    }
}

package org.kurron.domain
/**
 * Convenience object builder.
 */
class DailyUserAggregateBuilder {
    /**
     * Generates random data.
     */
    private final RandomDataGenerator generator = new RandomDataGenerator()

    DailyUserAggregate build() {
        DailyUserAggregate aggregate = new DailyUserAggregate()
        aggregate.id = generator.randomObjectId()
        aggregate.dateCode = generator.randomLong()
        aggregate.username = generator.randomHexString()
        aggregate.node = generator.randomHexString()
        aggregate.organization = generator.randomHexString()
        2.times {
            aggregate.schoolHouses << generator.randomHexString()
        }
        2.times {
            aggregate.tags << generator.randomHexString()
        }
        aggregate.newClassRegistrationCount = generator.randomNumberExclusive( 10 )
        aggregate.totalLessonSessionCount = generator.randomNumberExclusive( 10 )
        2.times {
            aggregate.languagesAccessed << generator.randomHexString()
        }
        aggregate.sustainment.learnedItemCount = generator.randomNumberExclusive( 10 )
        aggregate.sustainment.staleItemCount = generator.randomNumberExclusive( 100 )
        aggregate.sustainment.totalRefreshmentTime = generator.randomNumberExclusive( 100 )

        aggregate.instructor.totalReportsGeneratedCount = generator.randomNumberExclusive( 10 )
        aggregate.instructor.totalAssignmentsGeneratedCount = generator.randomNumberExclusive( 10 )
        aggregate.instructor.totalListsPublishedCount = generator.randomNumberExclusive( 10 )
        aggregate.instructor.totalClassesCreatedCount = generator.randomNumberExclusive( 10 )
        aggregate.instructor.totalInstructorPortalSessionCount = generator.randomNumberExclusive( 10 )

        aggregate.mobileData.downloadedListCount = generator.randomNumberExclusive( 10 )
        aggregate.mobileData.downloadedCourseCountCount = generator.randomNumberExclusive( 10 )
        aggregate.mobileData.sessionCount = generator.randomNumberExclusive( 10 )
        aggregate.mobileData.sessionTime = generator.randomNumberExclusive( 100 )

        aggregate.dektopData.downloadedListCount = generator.randomNumberExclusive( 10 )
        aggregate.dektopData.downloadedCourseCountCount = generator.randomNumberExclusive( 10 )
        aggregate.dektopData.sessionCount = generator.randomNumberExclusive( 10 )
        aggregate.dektopData.sessionTime = generator.randomNumberExclusive( 100 )

        aggregate.webData.downloadedListCount = generator.randomNumberExclusive( 10 )
        aggregate.webData.downloadedCourseCountCount = generator.randomNumberExclusive( 10 )
        aggregate.webData.sessionCount = generator.randomNumberExclusive( 10 )
        aggregate.webData.sessionTime = generator.randomNumberExclusive( 100 )

        3.times {
            ClassParticipation participation = new ClassParticipation()
            participation.code = generator.randomHexString()
            participation.totalLearningTime = generator.randomNumberExclusive( 100 )
            aggregate.classParticipation << participation
        }
        aggregate
    }
}

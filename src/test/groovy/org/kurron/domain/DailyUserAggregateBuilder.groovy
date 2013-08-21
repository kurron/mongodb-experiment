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

    private final ClassParticipationBuilder classParticipationBuilder = new ClassParticipationBuilder()

    private final AssetListBuilder assetListBuilder = new AssetListBuilder()

    private final LanguagePairBuilder languagePairBuilder = new LanguagePairBuilder()

    private final LearningContentBuilder learningContentBuilder = new LearningContentBuilder()

    private final CourseProgressBuilder courseProgressBuilder = new CourseProgressBuilder()

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
        aggregate.userInformation = generator.randomHexString()

        aggregate.student.code = generator.randomHexString()
        aggregate.student.sustainment.learnedItemCount = generator.randomNumberExclusive( 100 ) + 1
        aggregate.student.sustainment.staleItemCount = generator.randomNumberExclusive( aggregate.student.sustainment.learnedItemCount )
        aggregate.student.sustainment.totalRefreshmentTime = generator.randomNumberExclusive( 100 )

        4.times{
            aggregate.student.assetsDownloaded << assetListBuilder.build()
        }

        4.times {
            aggregate.student.languagesAccessed << languagePairBuilder.build()
        }

        4.times {
            aggregate.student.learningContent << learningContentBuilder.build()
        }

        3.times {
            aggregate.student.classParticipation << classParticipationBuilder.build()
        }

        4.times {
            aggregate.student.courseProgress << courseProgressBuilder.build()
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

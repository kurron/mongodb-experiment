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

    private final ClassParticipationBuilder classParticipationBuilder = new ClassParticipationBuilder()

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
        aggregate.student.totalLessonSessionCount = generator.randomNumberInclusive( 10 )
        aggregate.student.sustainment.learnedItemCount = generator.randomNumberInclusive( 10 )
        aggregate.student.sustainment.staleItemCount = generator.randomNumberInclusive( 100 )
        aggregate.student.sustainment.totalRefreshmentTime = generator.randomNumberInclusive( 100 )

        4.times {
            AssetList asset = new AssetList()
            asset.knownCode = knownLanguageListing[ generator.randomArrayIndex( knownLanguageListing.size() ) ]
            asset.learningCode = learningLanguageListing[ generator.randomArrayIndex( knownLanguageListing.size() ) ]
            asset.assetType = generator.randomAssetType()
            asset.platform = generator.randomPlatform()
            aggregate.student.assetsDownloaded << asset
        }

        4.times {
            LanguagePair pair = new LanguagePair()
            pair.knownCode = knownLanguageListing[ generator.randomArrayIndex( knownLanguageListing.size() ) ]
            pair.learningCode = learningLanguageListing[ generator.randomArrayIndex( knownLanguageListing.size() ) ]
            pair.sessionCount = generator.randomNumberInclusive( 10 )
            pair.sessionTime = pair.sessionCount // have one-minute sessions
            pair.platform = generator.randomPlatform()
            aggregate.student.languagesAccessed << pair
        }

        4.times {
            LearningContent content = new LearningContent()
            content.type = generator.randomBoolean() ? 'List' : 'Unit'
            content.title = generator.randomHexString()
            LanguagePair pair = new LanguagePair()
            pair.knownCode = knownLanguageListing[ generator.randomArrayIndex( knownLanguageListing.size() ) ]
            pair.learningCode = learningLanguageListing[ generator.randomArrayIndex( knownLanguageListing.size() ) ]
            pair.sessionCount = generator.randomNumberInclusive( 10 )
            content.pair = pair
            aggregate.student.learningContent << content
        }
        3.times {
            aggregate.student.classParticipation << classParticipationBuilder.build()
        }

        aggregate.instructor.instructorID = 'TEACHER.' + generator.randomHexString()
        aggregate.instructor.totalReportsGeneratedCount = generator.randomNumberInclusive( 10 )
        aggregate.instructor.totalAssignmentsGeneratedCount = generator.randomNumberInclusive( 10 )
        aggregate.instructor.totalListsPublishedCount = generator.randomNumberInclusive( 10 )
        aggregate.instructor.totalClassesCreatedCount = generator.randomNumberInclusive( 10 )
        aggregate.instructor.totalInstructorPortalSessionCount = generator.randomNumberInclusive( 10 )
        aggregate.instructor.totalInstructorPortalSessionTime = generator.randomNumberInclusive( 100 )

        aggregate.administrator.administratorID = generator.randomHexString()
        aggregate.administrator.totalReportsGeneratedCount = generator.randomNumberInclusive( 10 )
        aggregate.administrator.totalPortalSessionCount = generator.randomNumberInclusive( 10 )
        aggregate.administrator.totalPortalSessionTime = generator.randomNumberInclusive( 100 )


        aggregate
    }
}

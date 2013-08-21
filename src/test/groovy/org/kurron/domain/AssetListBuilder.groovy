package org.kurron.domain

import org.kurron.RandomDataGenerator

/**
 * Created with IntelliJ IDEA.
 * User: vagrant
 * Date: 8/21/13
 * Time: 2:44 PM
 * To change this template use File | Settings | File Templates.
 */
class AssetListBuilder {
    private final RandomDataGenerator generator = new RandomDataGenerator()

    AssetList build() {
        AssetList assetList = new AssetList()
        assetList.knownCode = generator.randomKnownLanguage()
        assetList.learningCode = generator.randomLearningLanguage()
        assetList.assetType = generator.randomAssetType()
        assetList.platform = generator.randomPlatform()
        assetList
    }
}
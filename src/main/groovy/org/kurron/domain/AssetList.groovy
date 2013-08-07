package org.kurron.domain

import com.fasterxml.jackson.annotation.JsonAutoDetect
import com.fasterxml.jackson.annotation.JsonProperty
import org.springframework.data.mongodb.core.mapping.Field

/**
 * Downloaded asset information
 */
@JsonAutoDetect( getterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE, isGetterVisibility = JsonAutoDetect.Visibility.NONE, fieldVisibility = JsonAutoDetect.Visibility.NONE )
class AssetList {
        @JsonProperty( value = 'known-code' )
        @Field( value = 'known-code' )
        String knownCode

        @JsonProperty( value = 'learning-code' )
        @Field( value = 'learning-code' )
        String learningCode

        @JsonProperty( value = 'platform')
        @Field( value = 'platform')
        String platform

        @JsonProperty( value = 'asset-type')
        @Field( value = 'asset-type')
        String assetType

        @Override
        public String toString() {
            return "AssetList{" +
                    "knownCode='" + knownCode + '\'' +
                    ", learningCode='" + learningCode + '\'' +
                    ", assetType=" + assetType + '\'' +
                    ", platform=" + platform +
                    '}';
    }
}
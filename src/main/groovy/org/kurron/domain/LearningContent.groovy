package org.kurron.domain

import com.fasterxml.jackson.annotation.JsonAutoDetect
import com.fasterxml.jackson.annotation.JsonProperty

/**
 * Records what content the user accessed.
 */
@JsonAutoDetect( getterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE, isGetterVisibility = JsonAutoDetect.Visibility.NONE, fieldVisibility = JsonAutoDetect.Visibility.NONE )
class LearningContent {
    @JsonProperty( value = 'content-type' )
    String type

    @JsonProperty( value = 'content-title' )
    String title

    @JsonProperty( value = 'language-pair' )
    LanguagePair pair
}

package org.kurron.domain

import com.fasterxml.jackson.annotation.JsonAutoDetect
import com.fasterxml.jackson.annotation.JsonProperty
import org.springframework.data.mongodb.core.mapping.Field

/**
 * Records what content the user accessed.
 */
@JsonAutoDetect( getterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE, isGetterVisibility = JsonAutoDetect.Visibility.NONE, fieldVisibility = JsonAutoDetect.Visibility.NONE )
class LearningContent {
    @JsonProperty( value = 'content-type' )
    @Field( value = 'content-type' )
    String type

    @JsonProperty( value = 'content-title' )
    @Field( value = 'content-title' )
    String title

    @JsonProperty( value = 'language-pair' )
    @Field( value = 'language-pair' )
    LanguagePair pair

    @Override
    public String toString() {
        return "LearningContent{" +
                "type='" + type + '\'' +
                ", title='" + title + '\'' +
                ", pair=" + pair +
                '}';
    }
}

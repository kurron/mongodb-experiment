package org.kurron.domain

import com.fasterxml.jackson.annotation.JsonAutoDetect
import com.fasterxml.jackson.annotation.JsonProperty
import org.springframework.data.mongodb.core.mapping.Field

/**
 * Language code pairs.
 */
@JsonAutoDetect( getterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE, isGetterVisibility = JsonAutoDetect.Visibility.NONE, fieldVisibility = JsonAutoDetect.Visibility.NONE )
class LanguagePair {
    @JsonProperty( value = 'known-code' )
    @Field( value = 'known-code' )
    String knownCode

    @JsonProperty( value = 'learning-code' )
    @Field( value = 'learning-code' )
    String learningCode

    @JsonProperty( value = 'session-count' )
    @Field( value = 'session-count' )
    int sessionCount

    @JsonProperty( value = 'session-time')
    @Field( value = 'session-time')
    int sessionTime

    @JsonProperty( value = 'platform')
    @Field( value = 'platform')
    String platform

    @Override
    public String toString() {
        return "LanguagePair{" +
                "knownCode='" + knownCode + '\'' +
                ", learningCode='" + learningCode + '\'' +
                ", sessionCount=" + sessionCount + '\'' +
                ", platform=" + platform +
                '}';
    }
}

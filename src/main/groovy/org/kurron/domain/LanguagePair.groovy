package org.kurron.domain

import com.fasterxml.jackson.annotation.JsonAutoDetect
import com.fasterxml.jackson.annotation.JsonProperty

/**
 * Language code pairs.
 */
@JsonAutoDetect( getterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE, isGetterVisibility = JsonAutoDetect.Visibility.NONE, fieldVisibility = JsonAutoDetect.Visibility.NONE )
class LanguagePair {
    @JsonProperty( value = 'known-code' )
    String knownCode

    @JsonProperty( value = 'learning-code' )
    String learningCode

    @JsonProperty( value = 'session-count' )
    int sessionCount


    @Override
    public java.lang.String toString() {
        return "LanguagePair{" +
                "knownCode='" + knownCode + '\'' +
                ", learningCode='" + learningCode + '\'' +
                ", sessionCount=" + sessionCount +
                '}';
    }
}

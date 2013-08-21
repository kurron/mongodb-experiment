package org.kurron.domain

import com.fasterxml.jackson.annotation.JsonAutoDetect
import com.fasterxml.jackson.annotation.JsonProperty
import org.springframework.data.mongodb.core.mapping.Field

/**
 * Information about a student's progress in class.
 */
@JsonAutoDetect( getterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE, isGetterVisibility = JsonAutoDetect.Visibility.NONE, fieldVisibility = JsonAutoDetect.Visibility.NONE )
class CourseProgress {
    @JsonProperty( value = 'course-status')
    @Field( value = 'course-status')
    String courseStatus

    @JsonProperty( value = 'language-pair' )
    @Field( value = 'language-pair' )
    LanguagePair pair

    @Override
    public String toString() {
        return "CourseProgress{" +
                "courseStatus=" + courseStatus +
                ", pair=" + pair +
                '}';
    }
}

package org.kurron.domain

import com.fasterxml.jackson.annotation.JsonAutoDetect
import com.fasterxml.jackson.annotation.JsonProperty
import org.springframework.data.mongodb.core.mapping.Field

/**
 * Information about a student's progress in class.
 */
@JsonAutoDetect( getterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE, isGetterVisibility = JsonAutoDetect.Visibility.NONE, fieldVisibility = JsonAutoDetect.Visibility.NONE )
class CourseProgress {
    @JsonProperty( value = 'course-id')
    @Field( value = 'course-id')
    String courseID

    @JsonProperty( value = 'course-status')
    @Field( value = 'course-status')
    String courseStatus

    @JsonProperty( value = 'language-pair' )
    @Field( value = 'language-pair' )
    LanguagePairWithoutPlatform pair

    @Override
    public String toString() {
        return "CourseProgress{" +
                "courseID=" + courseID +
                ", courseStatus=" + courseStatus +
                ", pair=" + pair +
                '}';
    }
}

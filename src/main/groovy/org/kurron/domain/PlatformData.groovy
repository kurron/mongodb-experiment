package org.kurron.domain

import com.fasterxml.jackson.annotation.JsonAutoDetect
import com.fasterxml.jackson.annotation.JsonProperty

/**
 * Information about a single user usage of a particular platform.
 */
@JsonAutoDetect( getterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE, isGetterVisibility = JsonAutoDetect.Visibility.NONE, fieldVisibility = JsonAutoDetect.Visibility.NONE )
class PlatformData {
    @JsonProperty( value = 'downloaded-list-count' )
    int downloadedListCount

    @JsonProperty( value = 'downloaded-course-count' )
    int downloadedCourseCountCount

    @JsonProperty( value = 'session-count' )
    int sessionCount

    @JsonProperty( value = 'session-time' )
    int sessionTime
}

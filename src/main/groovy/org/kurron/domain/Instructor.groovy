package org.kurron.domain

import com.fasterxml.jackson.annotation.JsonAutoDetect
import com.fasterxml.jackson.annotation.JsonProperty

/**
 * Information about a single user in the system.
 */
@JsonAutoDetect( getterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE, isGetterVisibility = JsonAutoDetect.Visibility.NONE, fieldVisibility = JsonAutoDetect.Visibility.NONE )
class Instructor {
    @JsonProperty( value = 'total-reports-generated-coun' )
    int totalReportsGeneratedCount

    @JsonProperty( value = 'total-assignments-generated-count' )
    int totalAssignmentsGeneratedCount

    @JsonProperty( value = 'total-lists-published-count' )
    int totalListsPublishedCount

    @JsonProperty( value = 'total-classes-created-count' )
    int totalClassesCreatedCount

    @JsonProperty( value = 'total-instructor-portal-session-count' )
    int totalInstructorPortalSessionCount
}

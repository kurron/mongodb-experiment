package org.kurron.domain

import com.fasterxml.jackson.annotation.JsonAutoDetect
import com.fasterxml.jackson.annotation.JsonProperty
import org.springframework.data.mongodb.core.mapping.Field

/**
 * Information about a single user in the system.
 */
@JsonAutoDetect( getterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE, isGetterVisibility = JsonAutoDetect.Visibility.NONE, fieldVisibility = JsonAutoDetect.Visibility.NONE )
class Instructor {
    @JsonProperty( value = 'instructor-id' )
    @Field( value = 'instructor-id' )
    String instructorID

    @JsonProperty( value = 'total-reports-generated-count' )
    @Field( value = 'total-reports-generated-count' )
    int totalReportsGeneratedCount

    @JsonProperty( value = 'total-assignments-generated-count' )
    @Field( value = 'total-assignments-generated-count' )
    int totalAssignmentsGeneratedCount

    @JsonProperty( value = 'total-lists-published-count' )
    @Field( value = 'total-lists-published-count' )
    int totalListsPublishedCount

    @JsonProperty( value = 'total-classes-created-count' )
    @Field( value = 'total-classes-created-count' )
    int totalClassesCreatedCount

    @JsonProperty( value = 'total-instructor-portal-session-count' )
    @Field( value = 'total-instructor-portal-session-count' )
    int totalInstructorPortalSessionCount

    @JsonProperty( value = 'total-instructor-portal-session-time' )
    @Field( value = 'total-instructor-portal-session-time' )
    int totalInstructorPortalSessionTime


    @Override
    public String toString() {
        return "Instructor{" +
                "instructorID='" + instructorID + '\'' +
                ", totalReportsGeneratedCount=" + totalReportsGeneratedCount +
                ", totalAssignmentsGeneratedCount=" + totalAssignmentsGeneratedCount +
                ", totalListsPublishedCount=" + totalListsPublishedCount +
                ", totalClassesCreatedCount=" + totalClassesCreatedCount +
                ", totalInstructorPortalSessionCount=" + totalInstructorPortalSessionCount +
                ", totalInstructorPortalSessionTime=" + totalInstructorPortalSessionTime +
                '}';
    }
}

package org.kurron.domain

import com.fasterxml.jackson.annotation.JsonAutoDetect
import com.fasterxml.jackson.annotation.JsonProperty

/**
 * Information about a single user in the system.
 */
@JsonAutoDetect( getterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE, isGetterVisibility = JsonAutoDetect.Visibility.NONE, fieldVisibility = JsonAutoDetect.Visibility.NONE )
class UserInformation {
    @JsonProperty( value = '_id' )
    String id

    @JsonProperty( value = 'student-id' )
    String studentID

    @JsonProperty( value = 'email' )
    String email

    @JsonProperty( value = 'last-logged-in-as-student' )
    long lastLogInAsStudent

    @JsonProperty( value = 'last-logged-in-as-instructor' )
    long lastLogInAsInstructor

    @JsonProperty( value = 'last-logged-in-as-administrator' )
    long lastLogInAsAdministrator

    @JsonProperty( value = 'administrator-id' )
    String administratorID

    @JsonProperty( value = 'instructor-id' )
    String instructorID

}

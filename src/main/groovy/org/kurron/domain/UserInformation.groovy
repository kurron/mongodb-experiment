package org.kurron.domain

import com.fasterxml.jackson.annotation.JsonAutoDetect
import com.fasterxml.jackson.annotation.JsonProperty
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field

/**
 * Information about a single user in the system.
 */
@JsonAutoDetect( getterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE, isGetterVisibility = JsonAutoDetect.Visibility.NONE, fieldVisibility = JsonAutoDetect.Visibility.NONE )
@Document
class UserInformation {
    @JsonProperty( value = '_id' )
    @Field( value = '_id' )
    String id

    @JsonProperty( value = 'instance')
    @Field( value = 'instance')
    String instance

    @JsonProperty( value = 'node')
    @Field( value = 'node')
    String node

    @JsonProperty( value = 'organization')
    @Field( value = 'organization')
    String organization

    @JsonProperty( value = 'tags' )
    @Field( value = 'tags' )
    List<String> tags = new ArrayList<>( 2 )

    @JsonProperty( value = 'is-active')
    @Field( value = 'is-active')
    Boolean isActive

    @JsonProperty( value = 'date-created')
    @Field( value = 'date-created')
    long dateCreated

    @JsonProperty( value = 'date-deleted')
    @Field( value = 'date-deleted')
    long dateDeleted

    @JsonProperty( value = 'student-id' )
    @Field( value = 'student-id' )
    String studentID

    @JsonProperty( value = 'email' )
    @Field( value = 'email' )
    String email

    @JsonProperty( value = 'last-logged-in-as-student' )
    @Field( value = 'last-logged-in-as-student' )
    long lastLogInAsStudent

    @JsonProperty( value = 'last-logged-in-as-instructor' )
    @Field( value = 'last-logged-in-as-instructor' )
    long lastLogInAsInstructor

    @JsonProperty( value = 'last-logged-in-as-administrator' )
    @Field( value = 'last-logged-in-as-administrator' )
    long lastLogInAsAdministrator

    @JsonProperty( value = 'administrator-id' )
    @Field( value = 'administrator-id' )
    String administratorID

    @JsonProperty( value = 'instructor-id' )
    @Field( value = 'instructor-id' )
    String instructorID

    @Override
    public String toString() {
        return "UserInformation{" +
                "id='" + id + '\'' +
                ", instance='" + instance + '\'' +
                ", isActive=" + isActive +
                ", dateCreated=" + dateCreated +
                ", dateDeleted=" + dateDeleted +
                ", studentID='" + studentID + '\'' +
                ", email='" + email + '\'' +
                ", lastLogInAsStudent=" + lastLogInAsStudent +
                ", lastLogInAsInstructor=" + lastLogInAsInstructor +
                ", lastLogInAsAdministrator=" + lastLogInAsAdministrator +
                ", administratorID='" + administratorID + '\'' +
                ", instructorID='" + instructorID + '\'' +
                '}';
    }
}

package org.kurron.domain

import com.fasterxml.jackson.annotation.JsonAutoDetect
import com.fasterxml.jackson.annotation.JsonProperty

/**
 * Information about a user's daily activity in the system.
 */
@JsonAutoDetect( getterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE, isGetterVisibility = JsonAutoDetect.Visibility.NONE, fieldVisibility = JsonAutoDetect.Visibility.NONE )
class DailyUserAggregate {
    @JsonProperty( value = '_id' )
    String id

    @JsonProperty( value = 'date-code' )
    long dateCode

    @JsonProperty( value = 'node' )
    String node

    @JsonProperty( value = 'organization' )
    String organization

    @JsonProperty( value = 'school-houses' )
    List<String> schoolHouses = new ArrayList<>( 2 )

    @JsonProperty( value = 'tags' )
    List<String> tags = new ArrayList<>( 2 )

    @JsonProperty( value = 'total-lesson-session-count' )
    int totalLessonSessionCount

    @JsonProperty( value = 'student' )
    Student student = new Student()

    @JsonProperty( value = 'instructor' )
    Instructor instructor = new Instructor()

    @JsonProperty( value = 'administrator' )
    Administrator administrator = new Administrator()

    @JsonProperty( value = 'class-participation' )
    List<ClassParticipation> classParticipation = new ArrayList<>( 8 )
}

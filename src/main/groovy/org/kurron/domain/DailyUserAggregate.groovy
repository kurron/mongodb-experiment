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

    @JsonProperty( value = 'daily-aggregate-id' )
    String dailyAggregateId

    @JsonProperty( value = 'username' )
    String username

    @JsonProperty( value = 'node' )
    String node

    @JsonProperty( value = 'organization' )
    String organization

    @JsonProperty( value = 'tags' )
    List<String> tags = new ArrayList<>( 2 )

    @JsonProperty( value = 'new-class-registration-count' )
    int newClassRegistrationCount

    @JsonProperty( value = 'total-lesson-session-count' )
    int totalLessonSessionCount

    @JsonProperty( value = 'languages-accessed' )
    List<String> languagesAccessed = new ArrayList<>( 2 )

    @JsonProperty( value = 'sustainment' )
    Sustainment sustainment = new Sustainment()

    @JsonProperty( value = 'instructor' )
    Instructor instructor = new Instructor()

    @JsonProperty( value = 'mobile-data' )
    PlatformData mobileData = new PlatformData()

    @JsonProperty( value = 'desktop-data' )
    PlatformData dektopData = new PlatformData()
}

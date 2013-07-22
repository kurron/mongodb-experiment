package org.kurron.domain

import com.fasterxml.jackson.annotation.JsonAutoDetect
import com.fasterxml.jackson.annotation.JsonProperty

/**
 * Information about a single student in the system.
 */
@JsonAutoDetect( getterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE, isGetterVisibility = JsonAutoDetect.Visibility.NONE, fieldVisibility = JsonAutoDetect.Visibility.NONE )
class Student {
    @JsonProperty( value = 'student-id' )
    String studentID

    @JsonProperty( value = 'sustainment' )
    Sustainment sustainment = new Sustainment()

    @JsonProperty( value = 'mobile-data' )
    PlatformData mobileData = new PlatformData()

    @JsonProperty( value = 'desktop-data' )
    PlatformData desktopData = new PlatformData()

    @JsonProperty( value = 'web-data' )
    PlatformData webData = new PlatformData()

    @JsonProperty( value = 'new-class-registration-count' )
    int newClassRegistrationCount

    @JsonProperty( value = 'languages-accessed' )
    List<LanguagePair> languagesAccessed = new ArrayList<>( 2 )

    @JsonProperty( value = 'learning-content' )
    List<LearningContent> learningContent = new ArrayList<>( 2 )
}

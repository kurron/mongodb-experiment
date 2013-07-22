package org.kurron.domain

import com.fasterxml.jackson.annotation.JsonAutoDetect
import com.fasterxml.jackson.annotation.JsonProperty

/**
 * Information about a class in the system.
 */
@JsonAutoDetect( getterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE, isGetterVisibility = JsonAutoDetect.Visibility.NONE, fieldVisibility = JsonAutoDetect.Visibility.NONE )
class ClassInformation {
    @JsonProperty( value = '_id' )
    String id

    @JsonProperty( value = 'title' )
    String title

    @JsonProperty( value = 'code' )
    String code

    @JsonProperty( value = 'instructors' )
    List<String> instructors = new ArrayList<>( 2 )
}

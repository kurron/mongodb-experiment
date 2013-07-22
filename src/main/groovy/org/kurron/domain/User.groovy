package org.kurron.domain

import com.fasterxml.jackson.annotation.JsonAutoDetect
import com.fasterxml.jackson.annotation.JsonProperty

/**
 * Information about a single user in the system.
 */
@JsonAutoDetect( getterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE, isGetterVisibility = JsonAutoDetect.Visibility.NONE, fieldVisibility = JsonAutoDetect.Visibility.NONE )
class User {
    @JsonProperty( value = '_id' )
    String id

    @JsonProperty( value = 'username' )
    String username

    @JsonProperty( value = 'email' )
    String email

    @JsonProperty( value = 'last-logged-in' )
    long lastLogIn
}

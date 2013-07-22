package org.kurron.domain

import com.fasterxml.jackson.annotation.JsonAutoDetect
import com.fasterxml.jackson.annotation.JsonProperty

/**
 * Information about a single administrator in the system.
 */
@JsonAutoDetect( getterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE, isGetterVisibility = JsonAutoDetect.Visibility.NONE, fieldVisibility = JsonAutoDetect.Visibility.NONE )
class Administrator {
    @JsonProperty( value = 'administrator-id' )
    String administratorID

    @JsonProperty( value = 'total-reports-generated-count' )
    int totalReportsGeneratedCount

    @JsonProperty( value = 'total-admin-portal-session-count' )
    int totalPortalSessionCount

    @JsonProperty( value = 'total-admin-portal-session-time' )
    int totalPortalSessionTime
}

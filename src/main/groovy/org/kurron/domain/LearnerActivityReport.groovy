package org.kurron.domain

import com.fasterxml.jackson.annotation.JsonAutoDetect
import com.fasterxml.jackson.annotation.JsonProperty
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.index.CompoundIndex
import org.springframework.data.mongodb.core.index.CompoundIndexes
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field

/**
 * Information about a user's daily activity in the system.
 */
@JsonAutoDetect( getterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE, isGetterVisibility = JsonAutoDetect.Visibility.NONE, fieldVisibility = JsonAutoDetect.Visibility.NONE )
class LearnerActivityReport {
    @JsonProperty( value = 'organization' )
    @Field( value = 'organization' )
    String organization

    @JsonProperty( value = 'date-run' )
    @Field( value = 'date-run' )
    Date dateRun

    @JsonProperty( value = 'username' )
    @Field( value = 'username' )
    String username

    @JsonProperty( value = 'e-mail' )
    @Field( value = 'e-mail' )
    String email

    @JsonProperty( value = 'total-session-count' )
    @Field( value = 'total-session-count' )
    long totalSessionCount

    @JsonProperty( value = 'total-session-time' )
    @Field( value = 'total-session-time' )
    long totalSessionTime

    @JsonProperty( value = 'average-session-time' )
    @Field( value = 'average-session-time' )
    long averageSessionTime

    @JsonProperty( value = 'last-session-date' )
    @Field( value = 'last-session-date' )
    Date lastSessionDate

    @JsonProperty( value = 'total-web-session-count' )
    @Field( value = 'total-web-session-count' )
    long totalWebSessionCount

    @JsonProperty( value = 'total-mobile-session-count' )
    @Field( value = 'total-mobile-session-count' )
    long totalMobileSessionCount

    @JsonProperty( value = 'total-desktop-session-count' )
    @Field( value = 'total-desktop-session-count' )
    long totalDesktopSessionCount


    @Override
    public String toString() {
        return "LearnerActivityReport{" +
                "username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", totalSessionCount=" + totalSessionCount +
                ", totalSessionTime=" + totalSessionTime +
                ", averageSessionTime=" + averageSessionTime +
                ", lastSessionDate=" + lastSessionDate +
                ", totalWebSessionCount=" + totalWebSessionCount +
                ", totalMobileSessionCount=" + totalMobileSessionCount +
                ", totalDesktopSessionCount=" + totalDesktopSessionCount +
                '}';
    }
}

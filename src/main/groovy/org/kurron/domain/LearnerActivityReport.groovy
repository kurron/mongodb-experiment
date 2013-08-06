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
@Document
class LearnerActivityReport {
    @JsonProperty( value = 'total-session-count' )
    @Field( value = 'total-session-count' )
    long totalSessionCount

    @JsonProperty( value = 'count' )
    @Field( value = 'count' )
    long count


    @Override
    public String toString() {
        return "LearnerActivityReport{" +
                "totalSessionCount=" + totalSessionCount +
                ", count=" + count +
                '}';
    }
}

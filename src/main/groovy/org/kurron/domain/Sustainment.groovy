package org.kurron.domain

import com.fasterxml.jackson.annotation.JsonAutoDetect
import com.fasterxml.jackson.annotation.JsonProperty
import org.springframework.data.mongodb.core.mapping.Field

/**
 * Information about a single user in the system.
 */
@JsonAutoDetect( getterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE, isGetterVisibility = JsonAutoDetect.Visibility.NONE, fieldVisibility = JsonAutoDetect.Visibility.NONE )
class Sustainment {
    @JsonProperty( value = 'learned-item-count' )
    @Field( value = 'learned-item-count' )
    int learnedItemCount

    @JsonProperty( value = 'stale-item-count' )
    @Field( value = 'stale-item-count' )
    int staleItemCount

    @JsonProperty( value = 'total-refreshment-time' )
    @Field( value = 'total-refreshment-time' )
    int totalRefreshmentTime

    @Override
    public String toString() {
        return "Sustainment{" +
                "learnedItemCount=" + learnedItemCount +
                ", staleItemCount=" + staleItemCount +
                ", totalRefreshmentTime=" + totalRefreshmentTime +
                '}';
    }
}

package org.kurron.domain

import com.fasterxml.jackson.annotation.JsonAutoDetect
import com.fasterxml.jackson.annotation.JsonProperty

/**
 * Information about a student's participation in a class.
 */
@JsonAutoDetect( getterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE, isGetterVisibility = JsonAutoDetect.Visibility.NONE, fieldVisibility = JsonAutoDetect.Visibility.NONE )
class ClassParticipation {
    @JsonProperty( value = 'enrolled-today-flag' )
    boolean enrolledToday

    @JsonProperty( value = 'total-learning-time' )
    int totalLearningTime

    @JsonProperty( value = 'class-code' )
    String code
}

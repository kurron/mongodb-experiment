package org.kurron.domain

import com.fasterxml.jackson.annotation.JsonAutoDetect
import com.fasterxml.jackson.annotation.JsonProperty
import org.springframework.data.mongodb.core.mapping.Field

/**
 * Information about a student's participation in a class.
 */
@JsonAutoDetect( getterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE, isGetterVisibility = JsonAutoDetect.Visibility.NONE, fieldVisibility = JsonAutoDetect.Visibility.NONE )
class ClassParticipation {
    @JsonProperty( value = 'enrolled-today-flag' )
    @Field( value = 'enrolled-today-flag' )
    boolean enrolledToday

    @JsonProperty( value = 'total-learning-time' )
    @Field( value = 'total-learning-time' )
    int totalLearningTime

    @JsonProperty( value = 'class-code' )
    @Field( value = 'class-code' )
    String code

    /**
     * Id to the document in the ClassInformation collection.
     */
    @JsonProperty( value = 'class-information' )
    @Field( value = 'class-information' )
    String classInformation

    @Override
    public String toString() {
        return "ClassParticipation{" +
                "enrolledToday=" + enrolledToday +
                ", totalLearningTime=" + totalLearningTime +
                ", code='" + code + '\'' +
                '}';
    }
}

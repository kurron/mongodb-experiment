package org.kurron.domain

import com.fasterxml.jackson.annotation.JsonAutoDetect
import com.fasterxml.jackson.annotation.JsonProperty
import org.springframework.data.mongodb.core.mapping.Field

/**
 * Information about a single student in the system.
 */
@JsonAutoDetect( getterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE, isGetterVisibility = JsonAutoDetect.Visibility.NONE, fieldVisibility = JsonAutoDetect.Visibility.NONE )
class Student {
    @JsonProperty( value = 'student-id' )
    @Field( value = 'student-id' )
    String code

    @JsonProperty( value = 'sustainment' )
    @Field( value = 'sustainment' )
    Sustainment sustainment = new Sustainment()

    @JsonProperty( value = "assets-downloaded")
    @Field( value = "assets-downloaded")
    List<AssetList> assetsDownloaded = new ArrayList<>( 2 )

    @JsonProperty( value = 'languages-accessed' )
    @Field( value = 'languages-accessed' )
    List<LanguagePair> languagesAccessed = new ArrayList<>( 2 )


    @JsonProperty( value = 'learning-content' )
    @Field( value = 'learning-content' )
    List<LearningContent> learningContent = new ArrayList<>( 2 )

    @JsonProperty( value = 'class-enrollment' )
    @Field( value = 'class-enrollment' )
    List<ClassParticipation> classParticipation = new ArrayList<>( 8 )

    @Override
    public String toString() {
        return "Student{" +
                "studentID='" + code + '\'' +
                ", sustainment=" + sustainment +
                ", languagesAccessed=" + languagesAccessed +
                ", learningContent=" + learningContent +
                ", classParticipation=" + classParticipation +
                '}';
    }
}

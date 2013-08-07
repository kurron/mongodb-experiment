package org.kurron.domain

import com.fasterxml.jackson.annotation.JsonAutoDetect
import com.fasterxml.jackson.annotation.JsonProperty
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field

/**
 * Information about a class in the system.
 */
@Document
@JsonAutoDetect( getterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE, isGetterVisibility = JsonAutoDetect.Visibility.NONE, fieldVisibility = JsonAutoDetect.Visibility.NONE )
class ClassInformation {
    @JsonProperty( value = '_id' )
    @Field( value = '_id' )
    String id

    @JsonProperty( value = 'title' )
    @Field( value = 'title' )
    String title

    @JsonProperty( value = 'code' )
    @Field( value = 'code' )
    String code

    @JsonProperty( value = 'instructors' )
    @Field( value = 'instructors' )
    List<String> instructors = new ArrayList<>( 2 )


    @Override
    public String toString() {
        return "ClassInformation{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", code='" + code + '\'' +
                ", instructors=" + instructors +
                '}';
    }
}

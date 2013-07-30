package org.kurron.domain

import com.fasterxml.jackson.annotation.JsonAutoDetect
import com.fasterxml.jackson.annotation.JsonProperty
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.index.Indexed
import org.springframework.data.mongodb.core.mapping.Document

/**
 * Information about a user's daily activity in the system.
 */
@JsonAutoDetect( getterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE, isGetterVisibility = JsonAutoDetect.Visibility.NONE, fieldVisibility = JsonAutoDetect.Visibility.NONE )
@Document
class DailyUserAggregate {
    @Id
    @JsonProperty( value = '_id' )
    String id

    @JsonProperty( value = 'date-code' )
    @Indexed
    long dateCode

    @JsonProperty( value = 'instance')
    @Indexed
    String instance

    @JsonProperty( value = 'node' )
    @Indexed
    String node

    @JsonProperty( value = 'organization' )
    @Indexed
    String organization

    @JsonProperty( value = 'school-houses' )
    List<String> schoolHouses = new ArrayList<>( 2 )

    @JsonProperty( value = 'tags' )
    List<String> tags = new ArrayList<>( 2 )

    @JsonProperty( value = 'student' )
    Student student = new Student()

    @JsonProperty( value = 'instructor' )
    Instructor instructor = new Instructor()

    @JsonProperty( value = 'administrator' )
    Administrator administrator = new Administrator()


    @Override
    public java.lang.String toString() {
        return "DailyUserAggregate{" +
                "id='" + id + '\'' +
                ", dateCode=" + dateCode +
                ", instance='" + instance + '\'' +
                ", node='" + node + '\'' +
                ", organization='" + organization + '\'' +
                ", schoolHouses=" + schoolHouses +
                ", tags=" + tags +
                ", student=" + student +
                ", instructor=" + instructor +
                ", administrator=" + administrator +
                '}';
    }
}

package org.kurron.domain

import com.fasterxml.jackson.annotation.JsonAutoDetect
import com.fasterxml.jackson.annotation.JsonProperty
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.index.Indexed
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field

/**
 * Information about a user's daily activity in the system.
 */
@JsonAutoDetect( getterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE, isGetterVisibility = JsonAutoDetect.Visibility.NONE, fieldVisibility = JsonAutoDetect.Visibility.NONE )
@Document
class DailyUserAggregate {
    @Id
    @JsonProperty( value = '_id' )
    @Field( value = '_id' )
    String id

    @JsonProperty( value = 'date-code' )
    @Field( value = 'date-code' )
    @Indexed
    long dateCode

    @JsonProperty( value = 'instance')
    @Field( value = 'instance')
    @Indexed
    String instance

    @JsonProperty( value = 'node' )
    @Field( value = 'node' )
    @Indexed
    String node

    @JsonProperty( value = 'organization' )
    @Field( value = 'organization' )
    @Indexed
    String organization

    @JsonProperty( value = 'school-houses' )
    @Field( value = 'school-houses' )
    List<String> schoolHouses = new ArrayList<>( 2 )

    @JsonProperty( value = 'tags' )
    @Field( value = 'tags' )
    List<String> tags = new ArrayList<>( 2 )

    @JsonProperty( value = 'student' )
    @Field( value = 'student' )
    Student student = new Student()

    @JsonProperty( value = 'instructor' )
    @Field( value = 'instructor' )
    Instructor instructor = new Instructor()

    @JsonProperty( value = 'administrator' )
    @Field( value = 'administrator' )
    Administrator administrator = new Administrator()

    @Override
    public String toString() {
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

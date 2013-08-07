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
@CompoundIndexes([ @CompoundIndex( name = 'node-instance-organization-date-index', def = "{'instance': 1, 'node':1, 'organization':1, 'date-code':1}" ) ])
class DailyUserAggregate {
    @Id
    @JsonProperty( value = '_id' )
    @Field( value = '_id' )
    String id

    @JsonProperty( value = 'date-code' )
    @Field( value = 'date-code' )
    long dateCode

    @JsonProperty( value = 'instance')
    @Field( value = 'instance')
    String instance

    @JsonProperty( value = 'node' )
    @Field( value = 'node' )
    String node

    @JsonProperty( value = 'organization' )
    @Field( value = 'organization' )
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

    /**
     * Id to the document in the UserInformation collection.
     */
    @JsonProperty( value = 'user-information' )
    @Field( value = 'user-information' )
    String userInformation

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

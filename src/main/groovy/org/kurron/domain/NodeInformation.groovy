package org.kurron.domain

import com.fasterxml.jackson.annotation.JsonAutoDetect
import com.fasterxml.jackson.annotation.JsonProperty
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field
/**
 * Created with IntelliJ IDEA.
 * User: vagrant
 * Date: 8/13/13
 * Time: 10:42 AM
 * To change this template use File | Settings | File Templates.
 */
@JsonAutoDetect( getterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE, isGetterVisibility = JsonAutoDetect.Visibility.NONE, fieldVisibility = JsonAutoDetect.Visibility.NONE )
@Document
class NodeInformation {
    @JsonProperty( value = '_id' )
    @Field( value = '_id' )
    String id

    @JsonProperty( value = 'instance')
    @Field( value = 'instance')
    String instance

    @JsonProperty( value = 'name')
    @Field( value = 'name')
    String name

    @JsonProperty( value = 'nickname')
    @Field( value = 'nickname')
    String nickname

    @JsonProperty( value = 'status' )
    @Field( value = 'status' )
    String status

    @JsonProperty( value = 'start-date')
    @Field( value = 'start-date')
    long startDate

    @JsonProperty( value = 'expiration-date')
    @Field( value = 'expiration-date')
    long expirationDate

    @JsonProperty( value = 'tl')
    @Field( value = 'tl')
    String tl

    @JsonProperty( value = 'partner-customer' )
    @Field( value = 'partner-customer' )
    String partnerCustomer

    @JsonProperty( value = 'value' )
    @Field( value = 'value' )
    long value

    @JsonProperty( value = 'sales-rep' )
    @Field( value = 'sales-rep' )
    String salesRep

    @JsonProperty( value = 'consortium' )
    @Field( value = 'consortium' )
    String consortium

    @Override
    public String toString() {
        return "UserInformation{" +
                "id='" + id + '\'' +
                ", instance='" + instance + '\'' +
                ", name=" + name + '\'' +
                ", nickname=" + nickname + '\'' +
                ", status=" + status + '\'' +
                ", startDate='" + startDate + '\'' +
                ", expirationDate='" + expirationDate + '\'' +
                ", tl=" + tl + '\'' +
                ", partnerCustomer=" + partnerCustomer +
                ", value=" + value + '\'' +
                ", salesRep='" + salesRep + '\'' +
                ", consortium='" + consortium + '\'' +
                '}';
    }
}


import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.SerializationFeature
import spock.lang.Specification

/**
 * A learning test just to see how the JSON structures might look.
 */
class JsonSerializerLearningTest extends Specification {
    def 'dump JSON structures'( def builder, def unimportant )
    {
        given: 'a JSON serializer'
        ObjectMapper mapper = new ObjectMapper()
        mapper.configure( SerializationFeature.INDENT_OUTPUT, true )
        mapper.configure( DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false )

        when: 'an object is serialized into JSON'
        def sut = builder.build()
        String json = mapper.writer().writeValueAsString( sut )

        then: 'printout JSON'
        println sut.class.simpleName
        println "$json"
        true

        where:
        builder                     |  unimportant
        new DailyAggregateBuilder() |  'bob'
        new UserInformationBuilder()           |  'bob'
    }
}

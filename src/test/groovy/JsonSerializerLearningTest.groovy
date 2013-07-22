import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.SerializationFeature
import org.kurron.domain.DailyAggregate
import spock.lang.Specification

/**
 * A learning test just to see how the JSON structures might look.
 */
class JsonSerializerLearningTest extends Specification {
    def 'bob'()
    {
        given: 'a JSON serializer'
        ObjectMapper mapper = new ObjectMapper()
        mapper.configure( SerializationFeature.INDENT_OUTPUT, true )
        mapper.configure( DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false )
        DailyAggregate sut = new DailyAggregate()
        sut.dateCode = System.currentTimeMillis()

        when: 'an object is serialized into JSON'
        String json = mapper.writer().writeValueAsString( sut )

        then: 'printout JSON'
        println "$json"
        true
    }
}

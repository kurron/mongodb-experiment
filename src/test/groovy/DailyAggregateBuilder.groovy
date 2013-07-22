import org.kurron.domain.DailyAggregate

/**
 * Convenience object builder.
 */
class DailyAggregateBuilder {
    /**
     * Generates random data.
     */
    private final RadomDataGenerator generator = new RadomDataGenerator()

    DailyAggregate build() {
        DailyAggregate aggregate = new DailyAggregate()
        aggregate.dateCode = generator.randomLong()
        aggregate.id = generator.randomObjectId()
        aggregate
    }
}

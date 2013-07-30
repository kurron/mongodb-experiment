package org.kurron.domain

import groovy.util.logging.Slf4j
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener

/**
 * Reacts to various life-cycle events.
 */
class DailyUserAggregateEventListener extends AbstractMongoEventListener<DailyUserAggregate> {
}

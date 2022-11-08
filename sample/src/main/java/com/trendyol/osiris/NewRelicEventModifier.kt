package com.trendyol.osiris

import com.trendyol.osiris.dispatcher.newrelic.NewRelicEvent

class NewRelicEventModifier : EventModifier {

    override fun modify(event: Event<EventData>): Event<EventData> {
        val newRelicEvent = event.data as NewRelicEvent

        return event.copy(data = newRelicEvent)
    }

    override fun isSatisfied(event: Event<EventData>): Boolean {
        return event.data is NewRelicEvent
    }
}

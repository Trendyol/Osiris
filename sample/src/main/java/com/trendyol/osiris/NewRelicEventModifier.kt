package com.trendyol.osiris

import com.trendyol.osiris.event.newrelic.NewRelicEventData

class NewRelicEventModifier : EventModifier {

    override fun modify(event: Event<EventData>): Event<EventData> {
        val newRelicEventData = event.data as NewRelicEventData
        return event.copy(data = newRelicEventData)
    }

    override fun isSatisfied(event: Event<EventData>): Boolean {
        return event.data is NewRelicEventData
    }
}

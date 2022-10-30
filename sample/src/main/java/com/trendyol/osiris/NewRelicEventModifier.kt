package com.trendyol.osiris

import com.trendyol.osiris.dispatcher.newrelic.NewRelicEvent

class NewRelicEventModifier : EventModifier<NewRelicEvent> {

    override fun modify(event: NewRelicEvent): NewRelicEvent {
        val newAttributes = event.attributes.toMutableMap()
        newAttributes["a"] = "b"
        return event.copy(attributes = newAttributes)
    }

    override fun isSatisfied(event: Event): Boolean {
        return event is NewRelicEvent
    }
}

package com.trendyol.osiris.dispatcher.newrelic

import com.newrelic.agent.android.NewRelic
import com.trendyol.osiris.EventDispatcher
import com.trendyol.osiris.Event

class NewRelicDispatcher : EventDispatcher {

    override fun logEvent(event: Event) {
        val newRelicEvent = event as NewRelicEvent
        NewRelic.recordCustomEvent(newRelicEvent.name, newRelicEvent.attributes)
    }

    override fun isSatisfied(event: Event): Boolean {
        return event is NewRelicEvent
    }
}

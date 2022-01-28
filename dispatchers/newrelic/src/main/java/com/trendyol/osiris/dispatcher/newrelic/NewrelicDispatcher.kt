package com.trendyol.osiris.dispatcher.newrelic

import com.newrelic.agent.android.NewRelic
import com.trendyol.osiris.Dispatcher
import com.trendyol.osiris.Event

class NewrelicDispatcher : Dispatcher {

    override fun logEvent(event: Event) {
        val newRelicEvent = event as NewrelicEvent
        NewRelic.recordCustomEvent(newRelicEvent.name, newRelicEvent.attributes)
    }

    override fun isSatisfied(event: Event): Boolean {
        return event is NewrelicEvent
    }
}

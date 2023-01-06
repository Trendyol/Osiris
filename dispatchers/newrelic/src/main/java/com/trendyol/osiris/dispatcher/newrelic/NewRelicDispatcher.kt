package com.trendyol.osiris.dispatcher.newrelic

import com.newrelic.agent.android.NewRelic
import com.trendyol.osiris.EventDispatcher
import com.trendyol.osiris.Event
import com.trendyol.osiris.EventData

class NewRelicDispatcher : EventDispatcher {

    override fun logEvent(event: Event<EventData>) {
        val newRelicEventData = event.data as NewRelicEventData
        NewRelic.recordCustomEvent(event.name, newRelicEventData.params)
    }

    override fun isSatisfied(event: Event<EventData>): Boolean {
        return event.data is NewRelicEventData
    }
}

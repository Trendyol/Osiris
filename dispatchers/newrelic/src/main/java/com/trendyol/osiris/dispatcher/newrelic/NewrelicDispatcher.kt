package com.trendyol.osiris.dispatcher.newrelic

import com.trendyol.osiris.Dispatcher
import com.trendyol.osiris.Event

class NewrelicDispatcher : Dispatcher {

    override fun logEvent(event: Event) {
        TODO("Not yet implemented")
    }

    override fun isSatisfied(event: Event): Boolean {
        return event is NewrelicEvent
    }
}

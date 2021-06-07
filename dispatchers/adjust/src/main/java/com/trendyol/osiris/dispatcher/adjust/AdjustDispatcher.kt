package com.trendyol.osiris.dispatcher.adjust

import com.trendyol.osiris.Dispatcher
import com.trendyol.osiris.Event

class AdjustDispatcher : Dispatcher {

    init {
        // todo init adjust
    }

    override fun logEvent(event: Event) {
        println(event.name)
    }

    override fun isSatisfied(event: Event): Boolean {
        return event is AdjustEvent
    }
}

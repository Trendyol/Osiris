package com.trendyol.osiris.dispatcher.delphoi

import com.trendyol.osiris.Dispatcher
import com.trendyol.osiris.Event

class DelphoiDispatcher : Dispatcher {

    override fun init() {
        // todo init delphoi
    }

    override fun logEvent(event: Event) {
        TODO("Not yet implemented")
    }

    override fun isSatisfied(event: Event): Boolean {
        return event is DelphoiEvent
    }
}

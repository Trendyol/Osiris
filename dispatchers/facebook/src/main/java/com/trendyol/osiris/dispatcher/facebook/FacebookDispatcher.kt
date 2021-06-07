package com.trendyol.osiris.dispatcher.facebook

import android.content.Context
import com.trendyol.osiris.Dispatcher
import com.trendyol.osiris.Event

class FacebookDispatcher(context: Context) : Dispatcher {

    init {
        // todo init facebook with context
    }

    override fun logEvent(event: Event) {
        TODO("Not yet implemented")
    }

    override fun isSatisfied(event: Event): Boolean {
        return event is FacebookEvent
    }
}

package com.trendyol.osiris.dispatcher.firebase

import android.content.Context
import com.trendyol.osiris.Dispatcher
import com.trendyol.osiris.Event

class FirebaseDispatcher(context: Context) : Dispatcher {

    override fun init() {
        // todo init firebase with context
    }

    override fun logEvent(event: Event) {
        println(event.name)
    }

    override fun isSatisfied(event: Event): Boolean {
        return event is FirebaseEvent
    }
}

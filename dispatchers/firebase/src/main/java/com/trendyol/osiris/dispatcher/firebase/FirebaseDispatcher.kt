package com.trendyol.osiris.dispatcher.firebase

import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.analytics.ktx.analytics
import com.google.firebase.ktx.Firebase
import com.trendyol.osiris.Dispatcher
import com.trendyol.osiris.Event

class FirebaseDispatcher : Dispatcher {

    private val firebase: FirebaseAnalytics = Firebase.analytics

    private val mapper by lazy { FirebaseEventMapper() }

    override fun logEvent(event: Event) {
        val firebaseEvent = event as FirebaseEvent
        val bundle = mapper.map(event)
        firebase.logEvent(firebaseEvent.name, bundle)
    }

    override fun isSatisfied(event: Event): Boolean {
        return event is FirebaseEvent
    }
}

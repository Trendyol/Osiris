package com.trendyol.osiris.dispatcher.firebase

import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.analytics.ktx.analytics
import com.google.firebase.ktx.Firebase
import com.trendyol.osiris.EventDispatcher
import com.trendyol.osiris.Event
import com.trendyol.osiris.EventData

class FirebaseDispatcher : EventDispatcher {

    private val firebase: FirebaseAnalytics = Firebase.analytics

    private val mapper by lazy { FirebaseEventMapper() }

    override fun logEvent(event: Event<EventData>) {
        val facebookEvent = event.data as FirebaseEvent
        val bundle = mapper.map(facebookEvent)
        //firebase.logEvent(event.name, bundle)
    }

    override fun isSatisfied(event: Event<EventData>): Boolean {
        return event.data is FirebaseEvent
    }
}

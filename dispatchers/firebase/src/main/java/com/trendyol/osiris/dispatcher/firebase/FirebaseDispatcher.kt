package com.trendyol.osiris.dispatcher.firebase

import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.analytics.ktx.analytics
import com.google.firebase.ktx.Firebase
import com.trendyol.osiris.EventDispatcher
import com.trendyol.osiris.Event
import com.trendyol.osiris.EventData
import com.trendyol.osiris.util.bundleOf

class FirebaseDispatcher : EventDispatcher {

    private val firebase: FirebaseAnalytics = Firebase.analytics

    override fun logEvent(event: Event<EventData>) {
        val firebaseEventData = event.data as FirebaseEventData
        firebase.logEvent(event.name, bundleOf(firebaseEventData.params))
    }

    override fun isSatisfied(event: Event<EventData>): Boolean {
        return event.data is FirebaseEventData
    }
}

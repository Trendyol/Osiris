package com.trendyol.osiris.dispatcher.firebase

import android.os.Bundle
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.analytics.ktx.analytics
import com.google.firebase.ktx.Firebase
import com.trendyol.osiris.Event
import com.trendyol.osiris.EventData
import com.trendyol.osiris.EventDispatcher

class FirebaseDispatcher : EventDispatcher {

    private val firebase: FirebaseAnalytics = Firebase.analytics

    override fun isSatisfied(event: Event<EventData>): Boolean {
        return event.data is FirebaseEventData
    }

    override fun logEvent(event: Event<EventData>) {
        val firebaseEventData = event.data as FirebaseEventData
        val params = getParamsAsBundle(firebaseEventData)
        firebase.logEvent(event.name, params)
    }

    private fun getParamsAsBundle(eventData: FirebaseEventData): Bundle {
        return eventData.params
            .map { it.key to it.value }
            .let { androidx.core.os.bundleOf(*it.toTypedArray()) }
    }
}

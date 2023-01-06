package com.trendyol.osiris.dispatcher.adjust

import com.adjust.sdk.Adjust
import com.adjust.sdk.AdjustConfig
import com.trendyol.osiris.Event
import com.trendyol.osiris.EventData
import com.trendyol.osiris.EventDispatcher
import com.trendyol.osiris.dispatcher.adjustevent.OsirisAdjustEventData

class AdjustDispatcher(adjustConfig: AdjustConfig) : EventDispatcher {

    private val eventAdapter by lazy { AdjustEventAdapter() }

    init {
        Adjust.onCreate(adjustConfig)
    }

    override fun logEvent(event: Event<EventData>) {
        val adjustEvent = eventAdapter.adapt(event)
        Adjust.trackEvent(adjustEvent)
    }

    override fun isSatisfied(event: Event<EventData>): Boolean {
        return event.data is OsirisAdjustEventData
    }
}

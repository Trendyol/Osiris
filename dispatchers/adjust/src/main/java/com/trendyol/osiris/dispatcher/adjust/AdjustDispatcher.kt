package com.trendyol.osiris.dispatcher.adjust

import com.adjust.sdk.Adjust
import com.adjust.sdk.AdjustConfig
import com.trendyol.osiris.Event
import com.trendyol.osiris.EventData
import com.trendyol.osiris.EventDispatcher

class AdjustDispatcher(adjustConfig: AdjustConfig) : EventDispatcher {

    private val adjustEventMapper by lazy { AdjustEventMapper() }

    init {
        Adjust.onCreate(adjustConfig)
    }

    override fun logEvent(event: Event<EventData>) {
        val adjustEvent = adjustEventMapper.map(event.data as OsirisAdjustEvent)
        Adjust.trackEvent(adjustEvent)
    }

    override fun isSatisfied(event: Event<EventData>): Boolean {
        return event.data is OsirisAdjustEvent
    }
}

package com.trendyol.osiris.dispatcher.adjust

import com.adjust.sdk.Adjust
import com.adjust.sdk.AdjustConfig
import com.trendyol.osiris.EventDispatcher
import com.trendyol.osiris.Event

class AdjustDispatcher(adjustConfig: AdjustConfig) : EventDispatcher {

    private val adjustEventMapper by lazy { AdjustEventMapper() }

    init {
        Adjust.onCreate(adjustConfig)
    }

    override fun logEvent(event: Event) {
        val adjustEvent = adjustEventMapper.map(event as OsirisAdjustEvent)
        Adjust.trackEvent(adjustEvent)
    }

    override fun isSatisfied(event: Event): Boolean {
        return event is OsirisAdjustEvent
    }
}

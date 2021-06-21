package com.trendyol.osiris.dispatcher.adjust

import com.adjust.sdk.Adjust
import com.adjust.sdk.AdjustConfig
import com.trendyol.osiris.Dispatcher
import com.trendyol.osiris.Event

class AdjustDispatcher(private val adjustConfig: AdjustConfig) : Dispatcher {

    private val adjustEventMapper by lazy { AdjustEventMapper() }

    override fun init() {
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

package com.trendyol.osiris

import com.trendyol.osiris.dispatcher.adjust.OsirisAdjustEvent

class AdjustEventModifier : EventModifier {

    override fun modify(event: Event<EventData>): Event<EventData> {
        val adjustEvent = event.data as OsirisAdjustEvent
        val newAdjustEvent = adjustEvent.copy(token = "newToken")
        return event.copy(data = newAdjustEvent)
    }

    override fun isSatisfied(event: Event<EventData>): Boolean {
        return event.data is OsirisAdjustEvent
    }
}

package com.trendyol.osiris

import com.trendyol.osiris.dispatcher.adjustevent.OsirisAdjustEvent

class AdjustEventModifier : EventModifier {

    override fun modify(event: Event<EventData>): Event<EventData> {
        val adjustEvent = event.data as OsirisAdjustEvent
        // Make modifications on event data
        return event.copy(data = adjustEvent)
    }

    override fun isSatisfied(event: Event<EventData>): Boolean {
        return event.data is OsirisAdjustEvent
    }
}

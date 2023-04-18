package com.trendyol.osiris

import com.trendyol.osiris.event.adjust.OsirisAdjustEventData

class AdjustEventModifier : EventModifier {

    override fun modify(event: Event<EventData>): Event<EventData> {
        val adjustEvent = event.data as OsirisAdjustEventData
        // Make modifications on event data
        return event.copy(data = adjustEvent)
    }

    override fun isSatisfied(event: Event<EventData>): Boolean {
        return event.data is OsirisAdjustEventData
    }
}

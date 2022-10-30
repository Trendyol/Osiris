package com.trendyol.osiris

import com.trendyol.osiris.dispatcher.adjust.OsirisAdjustEvent

class AdjustEventModifier : EventModifier<OsirisAdjustEvent> {

    override fun modify(event: OsirisAdjustEvent): OsirisAdjustEvent {
        return event.copy(token = "new-token")
    }

    override fun isSatisfied(event: Event): Boolean {
        return event is OsirisAdjustEvent
    }
}

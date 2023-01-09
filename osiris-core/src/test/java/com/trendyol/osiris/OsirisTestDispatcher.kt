package com.trendyol.osiris

class OsirisTestDispatcher : EventDispatcher {

    override fun logEvent(event: Event<EventData>) {
        // Do nothing
    }

    override fun isSatisfied(event: Event<EventData>): Boolean {
        return true
    }
}

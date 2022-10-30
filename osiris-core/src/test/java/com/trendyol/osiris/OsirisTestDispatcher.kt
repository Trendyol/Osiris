package com.trendyol.osiris

class OsirisTestDispatcher : EventDispatcher {

    override fun logEvent(event: Event) {
        // Do nothing
    }

    override fun isSatisfied(event: Event): Boolean {
        return true
    }
}

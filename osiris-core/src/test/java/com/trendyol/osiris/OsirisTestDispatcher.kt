package com.trendyol.osiris

class OsirisTestDispatcher : Dispatcher {

    override fun logEvent(event: Event) {
        // Do nothing
    }

    override fun isSatisfied(event: Event): Boolean {
        return true
    }
}

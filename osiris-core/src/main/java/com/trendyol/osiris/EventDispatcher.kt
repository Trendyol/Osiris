package com.trendyol.osiris

interface EventDispatcher {

    fun logEvent(event: Event<EventData>)

    fun isSatisfied(event: Event<EventData>): Boolean
}

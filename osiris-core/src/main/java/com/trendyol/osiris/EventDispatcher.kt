package com.trendyol.osiris

interface EventDispatcher {

    fun isSatisfied(event: Event<EventData>): Boolean

    fun logEvent(event: Event<EventData>)
}

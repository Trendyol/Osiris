package com.trendyol.osiris

interface EventDispatcher {

    fun logEvent(event: Event)

    fun isSatisfied(event: Event): Boolean
}

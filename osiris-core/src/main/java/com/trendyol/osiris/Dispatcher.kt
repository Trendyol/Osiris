package com.trendyol.osiris

interface Dispatcher {

    fun logEvent(event: Event)

    fun isSatisfied(event: Event): Boolean
}

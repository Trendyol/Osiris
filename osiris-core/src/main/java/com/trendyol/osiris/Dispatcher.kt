package com.trendyol.osiris

interface Dispatcher {

    fun init()

    fun logEvent(event: Event)

    fun isSatisfied(event: Event): Boolean
}

package com.trendyol.osiris

interface EventAdapter<T> {

    fun adapt(event: Event<EventData>): T
}

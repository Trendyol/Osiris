package com.trendyol.osiris

interface EventBuilder {

    fun build(): List<Event<EventData>>
}

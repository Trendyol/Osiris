package com.trendyol.osiris

interface EventModifier {

    fun modify(event: Event<EventData>): Event<EventData>

    fun isSatisfied(event: Event<EventData>): Boolean
}

package com.trendyol.osiris

interface EventModifier {
    fun modify(event: Event): Event
}

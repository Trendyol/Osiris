package com.trendyol.osiris

interface EventModifier<T : Event> {

    fun modify(event: T): T

    fun isSatisfied(event: Event): Boolean
}

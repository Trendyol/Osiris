package com.trendyol.osiris

class Osiris {

    private val dispatchers = mutableListOf<Dispatcher>()

    private val modifiers = mutableListOf<EventModifier>()

    fun addDispatchers(vararg dispatchers: Dispatcher) = apply {
        this.dispatchers.addAll(dispatchers)
    }

    fun addModifiers(vararg modifiers: EventModifier) = apply {
        this.modifiers.addAll(modifiers)
    }

    fun logEvents(vararg events: Event) {
        check(dispatchers.isNotEmpty()) { "At least one dispatcher should be set" }

        events.forEach { event ->
            val finalEvent: Event = modifiers.fold(event) { carriedEvent, eventModifier ->
                eventModifier.modify(carriedEvent)
            }

            val dispatcher: Dispatcher = dispatchers.find {
                it.isSatisfied(finalEvent)
            } ?: return@forEach

            dispatcher.logEvent(event)
        }
    }
}

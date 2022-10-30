package com.trendyol.osiris

class Osiris {

    private val dispatchers = mutableListOf<EventDispatcher>()

    private val modifiers = mutableListOf<EventModifier<Event>>()

    fun addDispatchers(vararg dispatchers: EventDispatcher) = apply {
        this.dispatchers.addAll(dispatchers)
    }

    fun addModifiers(vararg modifiers: EventModifier<Event>) = apply {
        this.modifiers.addAll(modifiers)
    }

    fun logEvents(events: List<Event>) {
        logEvents(*events.toTypedArray())
    }

    fun logEvents(vararg events: Event) {
        check(dispatchers.isNotEmpty()) { "At least one dispatcher should be set" }

        events.forEach { event ->
            val finalEvent: Event = modifiers.fold(event) { carriedEvent, eventModifier ->
                eventModifier.modify(carriedEvent)
            }

            val dispatcher: EventDispatcher = dispatchers.find {
                it.isSatisfied(finalEvent)
            } ?: return@forEach

            dispatcher.logEvent(event)
        }
    }
}

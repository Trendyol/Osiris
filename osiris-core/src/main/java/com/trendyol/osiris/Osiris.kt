package com.trendyol.osiris

class Osiris {

    private val dispatchers = mutableListOf<EventDispatcher>()

    private val modifiers = mutableListOf<EventModifier>()

    fun addDispatchers(vararg dispatchers: EventDispatcher) = apply {
        this.dispatchers.addAll(dispatchers)
    }

    fun addModifiers(vararg modifiers: EventModifier) = apply {
        this.modifiers.addAll(modifiers)
    }

    fun logEvents(events: List<Event<EventData>>) {
        logEvents(*events.toTypedArray())
    }

    fun logEvents(vararg eventBuilder: EventBuilder) {
        eventBuilder.forEach { logEvents(it.build()) }
    }

    fun logEvents(vararg events: Event<EventData>) {
        check(dispatchers.isNotEmpty()) { "At least one dispatcher should be set" }

        events.forEach { event ->
            val finalEvent: Event<EventData> = modifiers
                .filter { it.isSatisfied(event) }
                .fold(event) { carriedEvent, eventModifier ->
                    eventModifier.modify(carriedEvent)
                }

            dispatchers
                .find { it.isSatisfied(finalEvent) }
                ?.logEvent(finalEvent)
        }
    }
}

package com.trendyol.osiris

class Osiris private constructor(
    private val dispatchers: List<EventDispatcher>,
    private val modifiers: List<EventModifier>,
) {

    fun logEvents(events: List<Event<EventData>>) {
        logEvents(*events.toTypedArray())
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

    class Builder {

        private val dispatchers = mutableListOf<EventDispatcher>()

        private val modifiers = mutableListOf<EventModifier>()

        fun dispatcher(vararg dispatcher: EventDispatcher) = apply {
            this.dispatchers.addAll(dispatcher)
        }

        fun modifier(vararg modifier: EventModifier) = apply {
            this.modifiers.addAll(modifier)
        }

        fun dispatchers(dispatchers: List<EventDispatcher>) = apply {
            this.dispatchers.addAll(dispatchers)
        }

        fun modifiers(modifiers: List<EventModifier>) = apply {
            this.modifiers.addAll(modifiers)
        }

        fun build() = Osiris(
            dispatchers = dispatchers,
            modifiers = modifiers,
        )
    }
}

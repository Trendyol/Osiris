package com.trendyol.osiris

class Osiris {

    private val dispatchers = mutableListOf<Dispatcher>()

    fun addDispatchers(vararg dispatchers: Dispatcher) = apply {
        this.dispatchers.addAll(dispatchers)
    }

    fun logEvents(vararg events: Event) {
        check(dispatchers.isNotEmpty()) { "At least one dispatcher should be set" }

        events.forEach { event ->
            val dispatcher: Dispatcher = dispatchers.find { it.isSatisfied(event) } ?: return

            dispatcher.logEvent(event)
        }
    }
}

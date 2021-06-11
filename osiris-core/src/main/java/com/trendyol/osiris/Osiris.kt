package com.trendyol.osiris

class Osiris {

    private val dispatchers = mutableListOf<Dispatcher>()

    fun addDispatchers(vararg dispatchers: Dispatcher) {
        this.dispatchers.addAll(dispatchers)
    }

    fun logEvents(vararg events: Event) {
        events.forEach { event ->
            val dispatcher: Dispatcher = dispatchers.find { it.isSatisfied(event) } ?: return

            dispatcher.logEvent(event)
        }
    }
}

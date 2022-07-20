package com.trendyol.osiris

class ExampleEventModifier : EventModifier {

    override fun modify(event: Event): Event {
        return event.add("key-to-update", "value-to-update")
    }
}

package com.trendyol.osiris

class OsirisTestEventModifier : EventModifier {

    override fun modify(event: Event): Event {
        return event
            .add("key-to-modify-1", "modified-value-1")
            .add("key-to-modify-2", "modified-value-2")
    }
}

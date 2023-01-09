package com.trendyol.osiris

class OsirisTestEventModifier : EventModifier {

    override fun modify(event: Event<EventData>): Event<EventData> {
        val testEventData = event.data as OsirisTestEventData
        return event.copy(
            data = testEventData.copy(
                params = testEventData.params
                    .toMutableMap()
                    .apply {
                        put("key-to-modify-1", "modified-value-1")
                        put("key-to-modify-2", "modified-value-2")
                    }
            )
        )
    }

    override fun isSatisfied(event: Event<EventData>): Boolean {
        return true
    }
}

package com.trendyol.osiris

import com.trendyol.osiris.dispatcher.adjustevent.OsirisAdjustEvent
import com.trendyol.osiris.dispatcher.firebase.FirebaseEvent
import com.trendyol.osiris.dispatcher.newrelic.NewRelicEvent

class HomeScreenSeenEvent : EventBuilder {

    override fun build(): List<Event<EventData>> = listOf(
        buildFirebaseEvent(),
        buildAdjustEvent(),
        buildNewRelicEvent()
    )

    private fun buildFirebaseEvent() = Event(
        name = "testEvent",
        data = FirebaseEvent(
            emptyMap()
        )
    )

    private fun buildAdjustEvent() = Event(
        name = "testEvent",
        data = OsirisAdjustEvent(
            token = ""
        )
    )

    private fun buildNewRelicEvent() = Event(
        name = "testEvent",
        data = NewRelicEvent(
            mapOf("new" to "relic", "hello" to 1)
        )
    )
}

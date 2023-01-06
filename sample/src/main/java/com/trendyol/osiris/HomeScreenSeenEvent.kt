package com.trendyol.osiris

import com.trendyol.osiris.dispatcher.adjustevent.OsirisAdjustEventData
import com.trendyol.osiris.dispatcher.firebase.FirebaseEventData
import com.trendyol.osiris.dispatcher.newrelic.NewRelicEventData

class HomeScreenSeenEvent : EventBuilder {

    override fun build(): List<Event<EventData>> = listOf(
        buildFirebaseEvent(),
        buildAdjustEvent(),
        buildNewRelicEvent()
    )

    private fun buildFirebaseEvent() = Event(
        name = "testEvent",
        data = FirebaseEventData(
            emptyMap()
        )
    )

    private fun buildAdjustEvent() = Event(
        name = "testEvent",
        data = OsirisAdjustEventData(
            token = ""
        )
    )

    private fun buildNewRelicEvent() = Event(
        name = "testEvent",
        data = NewRelicEventData(
            mapOf("new" to "relic", "hello" to 1)
        )
    )
}

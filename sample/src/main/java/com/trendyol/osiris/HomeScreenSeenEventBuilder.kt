package com.trendyol.osiris

import com.trendyol.osiris.event.adjust.OsirisAdjustEventData
import com.trendyol.osiris.event.facebook.FacebookEventDataContract
import com.trendyol.osiris.event.firebase.FirebaseEventData
import com.trendyol.osiris.event.newrelic.NewRelicEventData

class HomeScreenSeenEventBuilder {

    fun build(): List<Event<EventData>> = listOf(
        buildFirebaseEvent(),
        buildAdjustEvent(),
        buildNewRelicEvent(),
        buildFacebookEvent()
    )

    private fun buildFirebaseEvent() = Event(
        name = "testEvent",
        data = FirebaseEventData(
            mapOf("fire" to "base", "hello" to 0)
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

    private fun buildFacebookEvent() = Event(
        name = "testFacebookEvent",
        data = FacebookEventDataContract.FacebookEventData(
            mapOf("face" to "book", "hello" to 2)
        )
    )
}

package com.trendyol.osiris

import com.trendyol.osiris.dispatcher.adjustevent.OsirisAdjustEventData
import com.trendyol.osiris.dispatcher.facebook.FacebookEventDataContract
import com.trendyol.osiris.dispatcher.firebase.FirebaseEventData
import com.trendyol.osiris.dispatcher.newrelic.NewRelicEventData

class HomeScreenSeenEventBuilder : EventBuilder {

    override fun build(): List<Event<EventData>> = listOf(
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

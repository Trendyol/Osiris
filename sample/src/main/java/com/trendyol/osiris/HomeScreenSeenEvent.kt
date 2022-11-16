package com.trendyol.osiris

import com.trendyol.osiris.dispatcher.adjustevent.OsirisAdjustEvent
import com.trendyol.osiris.dispatcher.firebase.FirebaseEvent

class HomeScreenSeenEvent : EventBuilder {

    override fun build(): List<Event<EventData>> = listOf(
        buildFirebaseEvent(),
        buildAdjustEvent(),
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
}

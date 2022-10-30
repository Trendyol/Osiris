package com.trendyol.osiris.dispatcher.firebase

import com.trendyol.osiris.Event
import com.trendyol.osiris.Osiris

data class FirebaseEvent(
    override val name: String,
    val parameters: Map<String, Any> = emptyMap(),
) : Event

interface EventBuilder {

    fun build(): List<Event>
}

class CartSeenEventBuilder : EventBuilder {

    override fun build() = listOf(
        buildFirebaseEvent(),
    )

    private fun buildFirebaseEvent(): Event {
        return FirebaseEvent(
            name = "testFirebase"
        )
    }
}

fun s(osiris: Osiris) {
    osiris.logEvents(CartSeenEventBuilder().build())
}
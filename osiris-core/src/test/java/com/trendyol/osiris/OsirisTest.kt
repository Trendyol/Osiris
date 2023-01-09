package com.trendyol.osiris

import io.mockk.every
import io.mockk.just
import io.mockk.mockkClass
import io.mockk.runs
import io.mockk.slot
import org.junit.Assert.assertEquals
import org.junit.Test

class OsirisTest {

    @Test
    fun `dispatcher_logEvent should send event modified by eventModifier implementations`() {
        // given
        val dispatcher: EventDispatcher = mockkClass(OsirisTestDispatcher::class)
        val eventName = "osiris-test-event"

        val osiris = Osiris()
            .addDispatchers(dispatcher)
            .addModifiers(OsirisTestEventModifier())

        val eventData = OsirisTestEventData(
            params = mapOf(
                "key-to-modify-1" to "value-to-modify-1",
                "key-to-modify-3" to "value-to-modify-3"
            )
        )

        val expectedEventData = OsirisTestEventData(
            params = mapOf(
                "key-to-modify-1" to "modified-value-1",
                "key-to-modify-2" to "modified-value-2",
                "key-to-modify-3" to "value-to-modify-3"
            )
        )

        val eventSlot = slot<Event<EventData>>()
        every { dispatcher.isSatisfied(any()) } returns true
        every { dispatcher.logEvent(capture(eventSlot)) } just runs

        // when
        osiris.logEvents(Event(eventName, eventData))

        // then
        assertEquals(eventSlot.captured.data, expectedEventData)
    }
}

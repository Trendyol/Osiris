package com.trendyol.osiris

import io.mockk.*
import org.junit.Assert.assertEquals
import org.junit.Test

class OsirisTest {

    @Test
    fun `dispatcher_logEvent should send event modified by eventModifier implementations`() {
        // given
        val dispatcher: EventDispatcher = mockkClass(OsirisTestDispatcher::class)

        val osiris = Osiris()
            .addDispatchers(dispatcher)
            .addModifiers(OsirisTestEventModifier())

        val event = OsirisTestEvent()

        event.add("key-to-modify-1", "value-to-modify-1")
        event.add("key-to-modify-3", "value-to-modify-3")

        val expectedEvent = OsirisTestEvent()
            .add("key-to-modify-1", "modified-value-1")
            .add("key-to-modify-2", "modified-value-2")
            .add("key-to-modify-3", "value-to-modify-3")

        val eventSlot = slot<Event>()
        every { dispatcher.isSatisfied(event) } returns true
        every { dispatcher.logEvent(capture(eventSlot)) } just runs

        // when
        osiris.logEvents(event)

        // then
        assertEquals(eventSlot.captured.getData(), expectedEvent.getData())
    }
}

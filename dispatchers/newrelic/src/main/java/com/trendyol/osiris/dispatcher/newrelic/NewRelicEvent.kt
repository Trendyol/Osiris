package com.trendyol.osiris.dispatcher.newrelic

import com.trendyol.osiris.Event

data class NewRelicEvent(
    override val name: String,
    val attributes: Map<String, Any>
) : Event(name)

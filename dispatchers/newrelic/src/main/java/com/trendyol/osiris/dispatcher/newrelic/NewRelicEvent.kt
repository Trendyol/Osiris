package com.trendyol.osiris.dispatcher.newrelic

import com.trendyol.osiris.EventData

data class NewRelicEvent(
    val params: Map<String, String>,
) : EventData

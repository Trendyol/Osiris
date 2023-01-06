package com.trendyol.osiris.dispatcher.newrelic

import com.trendyol.osiris.EventData

data class NewRelicEventData(
    val params: Map<String, Any>,
) : EventData

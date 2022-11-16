package com.trendyol.osiris.dispatcher.facebook

import com.trendyol.osiris.EventData

data class FacebookEvent(
    val price: Double,
    val currency: String,
    val params: Map<String, String>,
) : EventData

package com.trendyol.osiris.dispatcher.facebook

import com.trendyol.osiris.EventData

sealed class FacebookEventContract(open val params: Map<String, String>) {

    data class FacebookEvent(
        override val params: Map<String, String>,
    ) : EventData, FacebookEventContract(params)

    data class FacebookPurchaseEvent(
        override val params: Map<String, String>,
        val price: Double,
        val currency: String,
    ) : EventData, FacebookEventContract(params)
}

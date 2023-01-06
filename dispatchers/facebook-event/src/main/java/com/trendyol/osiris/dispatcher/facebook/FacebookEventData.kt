package com.trendyol.osiris.dispatcher.facebook

import com.trendyol.osiris.EventData

sealed class FacebookEventDataContract(open val params: Map<String, String>): EventData {

    data class FacebookEventData(
        override val params: Map<String, String>,
    ): FacebookEventDataContract(params)

    data class FacebookPurchaseEventData(
        override val params: Map<String, String>,
        val price: Double,
        val currency: String,
    ): FacebookEventDataContract(params)
}

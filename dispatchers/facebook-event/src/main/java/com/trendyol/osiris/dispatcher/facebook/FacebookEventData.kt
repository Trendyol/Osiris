package com.trendyol.osiris.dispatcher.facebook

import com.trendyol.osiris.EventData

sealed class FacebookEventDataContract(open val params: Map<String, Any>): EventData {

    data class FacebookEventData(
        override val params: Map<String, Any>,
    ): FacebookEventDataContract(params)

    data class FacebookPurchaseEventData(
        override val params: Map<String, Any>,
        val price: Double?,
        val currency: String?,
    ): FacebookEventDataContract(params)
}

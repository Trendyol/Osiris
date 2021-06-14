package com.trendyol.osiris.dispatcher.adjust.criteo

import android.net.Uri
import com.adjust.sdk.criteo.CriteoProduct

sealed class CriteoInjection {
    data class Cart(val products: List<CriteoProduct>) : CriteoInjection()
    data class Custom(val uiData: String) : CriteoInjection()
    data class Deeplink(val uri: Uri) : CriteoInjection()
    data class UserSegment(val userSegment: String) : CriteoInjection()
    data class ViewProduct(val productId: String) : CriteoInjection()
    data class ViewListing(val productIds: List<String>) : CriteoInjection()
    data class TransactionConfirmed(
        val products: List<CriteoProduct>,
        val transactionId: String,
        val newCustomer: String
    ) : CriteoInjection()
}

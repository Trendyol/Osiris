package com.trendyol.osiris.dispatcher.adjust

import com.adjust.sdk.AdjustEvent
import com.adjust.sdk.criteo.AdjustCriteo
import com.adjust.sdk.criteo.AdjustCriteo.injectCartIntoEvent
import com.trendyol.osiris.dispatcher.adjust.criteo.CriteoInjection
import com.trendyol.osiris.dispatcher.adjust.data.AdjustParameter
import com.trendyol.osiris.dispatcher.adjust.data.AdjustParametrizedData

internal fun AdjustEvent.addParameter(adjustEventData: AdjustParametrizedData) = with(adjustEventData) {
    when (parameter) {
        is AdjustParameter.Callback -> addCallbackParameter(key, parameter.data)
        is AdjustParameter.Partner -> addPartnerParameter(key, parameter.data)
        is AdjustParameter.PartnerAndCallback -> {
            addCallbackParameter(key, parameter.data)
            addPartnerParameter(key, parameter.data)
        }
    }
}

internal fun AdjustEvent.injectEvent(criteoInjection: CriteoInjection) {
    when (criteoInjection) {
        is CriteoInjection.Cart -> injectCartIntoEvent(this, criteoInjection.products)
        is CriteoInjection.Custom -> AdjustCriteo.injectCustomEventIntoEvent(this, criteoInjection.uiData)
        is CriteoInjection.Deeplink -> AdjustCriteo.injectDeeplinkIntoEvent(this, criteoInjection.uri)
        is CriteoInjection.TransactionConfirmed -> AdjustCriteo.injectTransactionConfirmedIntoEvent(
            this,
            criteoInjection.products,
            criteoInjection.transactionId,
            criteoInjection.newCustomer
        )
        is CriteoInjection.ViewListing -> AdjustCriteo.injectViewListingIntoEvent(this, criteoInjection.productIds)
        is CriteoInjection.ViewProduct -> AdjustCriteo.injectViewProductIntoEvent(this, criteoInjection.productId)
        is CriteoInjection.UserSegment -> AdjustCriteo.injectUserSegmentIntoCriteoEvents(criteoInjection.userSegment)
    }
}

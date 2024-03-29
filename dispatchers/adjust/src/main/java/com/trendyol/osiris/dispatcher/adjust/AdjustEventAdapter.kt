package com.trendyol.osiris.dispatcher.adjust

import com.adjust.sdk.AdjustEvent
import com.adjust.sdk.criteo.AdjustCriteo
import com.trendyol.osiris.Event
import com.trendyol.osiris.EventAdapter
import com.trendyol.osiris.EventData
import com.trendyol.osiris.event.adjust.criteo.CriteoInjection
import com.trendyol.osiris.event.adjust.data.AdjustParameter
import com.trendyol.osiris.event.adjust.data.AdjustParametrizedData
import com.trendyol.osiris.event.adjust.OsirisAdjustEventData

internal class AdjustEventAdapter : EventAdapter<AdjustEvent> {

    override fun adapt(event: Event<EventData>): AdjustEvent {
        val osirisAdjustEventData = event.data as OsirisAdjustEventData
        return AdjustEvent(osirisAdjustEventData.token).apply {
            osirisAdjustEventData.orderId?.let { orderId -> setOrderId(orderId) }
            osirisAdjustEventData.revenue?.let { revenueData -> setRevenue(revenueData.revenue, revenueData.currency) }
            osirisAdjustEventData.parameterizedData.forEach { data -> addParameter(data) }
            osirisAdjustEventData.criteoInject.forEach { criteoInjection -> injectEvent(criteoInjection) }
        }
    }

    private fun AdjustEvent.addParameter(
        adjustEventData: AdjustParametrizedData,
    ) = with(adjustEventData) {
        when (parameter) {
            is AdjustParameter.Callback -> addCallbackParameter(key, parameter.data)
            is AdjustParameter.Partner -> addPartnerParameter(key, parameter.data)
            is AdjustParameter.PartnerAndCallback -> {
                addCallbackParameter(key, parameter.data)
                addPartnerParameter(key, parameter.data)
            }
        }
    }

    private fun AdjustEvent.injectEvent(criteoInjection: CriteoInjection) = when (criteoInjection) {
        is CriteoInjection.Cart -> AdjustCriteo.injectCartIntoEvent(this, criteoInjection.products)
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

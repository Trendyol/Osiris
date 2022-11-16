package com.trendyol.osiris.dispatcher.adjust

import com.adjust.sdk.AdjustEvent
import com.adjust.sdk.criteo.AdjustCriteo
import com.trendyol.osiris.Event
import com.trendyol.osiris.EventAdapter
import com.trendyol.osiris.EventData
import com.trendyol.osiris.dispatcher.adjustevent.criteo.CriteoInjection
import com.trendyol.osiris.dispatcher.adjustevent.data.AdjustParameter
import com.trendyol.osiris.dispatcher.adjustevent.data.AdjustParametrizedData

internal class AdjustEventAdapter : EventAdapter<AdjustEvent> {

    override fun adapt(event: Event<EventData>): AdjustEvent {
        val osirisAdjustEvent = event.data as com.trendyol.osiris.dispatcher.adjustevent.OsirisAdjustEvent
        return AdjustEvent(osirisAdjustEvent.token).apply {
            osirisAdjustEvent.orderId?.let { orderId -> setOrderId(orderId) }
            osirisAdjustEvent.revenue?.let { revenueData -> setRevenue(revenueData.revenue, revenueData.currency) }
            osirisAdjustEvent.parameterizedData.forEach { data -> addParameter(data) }
            osirisAdjustEvent.criteoInject.forEach { criteoInjection -> injectEvent(criteoInjection) }
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
        is CriteoInjection.Custom -> AdjustCriteo.injectCustomEventIntoEvent(this, criteoInjection.uiData,)
        is CriteoInjection.Deeplink -> AdjustCriteo.injectDeeplinkIntoEvent(this, criteoInjection.uri,)
        is CriteoInjection.TransactionConfirmed -> AdjustCriteo.injectTransactionConfirmedIntoEvent(this, criteoInjection.products, criteoInjection.transactionId, criteoInjection.newCustomer)
        is CriteoInjection.ViewListing ->AdjustCriteo.injectViewListingIntoEvent(this, criteoInjection.productIds)
        is CriteoInjection.ViewProduct -> AdjustCriteo.injectViewProductIntoEvent(this, criteoInjection.productId)
        is CriteoInjection.UserSegment -> AdjustCriteo.injectUserSegmentIntoCriteoEvents(criteoInjection.userSegment)
    }
}

package com.trendyol.osiris.dispatcher.adjust

import com.adjust.sdk.AdjustEvent
import com.trendyol.osiris.Event
import com.trendyol.osiris.EventAdapter
import com.trendyol.osiris.EventData

class AdjustEventAdapter : EventAdapter<AdjustEvent> {

    override fun adapt(event: Event<EventData>): AdjustEvent {
        val osirisAdjustEvent = event.data as OsirisAdjustEvent
        return AdjustEvent(osirisAdjustEvent.token).apply {
            osirisAdjustEvent.orderId?.let { orderId -> setOrderId(orderId) }
            osirisAdjustEvent.revenue?.let { revenueData -> setRevenue(revenueData.revenue, revenueData.currency) }
            osirisAdjustEvent.parameterizedData.forEach { data -> addParameter(data) }
            osirisAdjustEvent.criteoInject.forEach { criteoInjection -> injectEvent(criteoInjection) }
        }
    }
}

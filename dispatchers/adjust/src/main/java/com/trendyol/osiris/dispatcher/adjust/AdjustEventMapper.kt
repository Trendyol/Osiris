package com.trendyol.osiris.dispatcher.adjust

import com.adjust.sdk.AdjustEvent

internal class AdjustEventMapper {

    fun map(osirisAdjustEvent: OsirisAdjustEvent) = AdjustEvent(osirisAdjustEvent.token).apply {
        osirisAdjustEvent.orderId?.let { orderId -> setOrderId(orderId) }
        osirisAdjustEvent.revenue?.let { revenueData -> setRevenue(revenueData.revenue, revenueData.currency) }
        osirisAdjustEvent.parameterizedData.forEach { data -> addParameter(data) }
        osirisAdjustEvent.criteoInject.forEach { criteoInjection -> injectEvent(criteoInjection) }
    }
}

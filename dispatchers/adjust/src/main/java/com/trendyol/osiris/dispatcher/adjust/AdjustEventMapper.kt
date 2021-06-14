package com.trendyol.osiris.dispatcher.adjust

import com.adjust.sdk.AdjustEvent

internal class AdjustEventMapper {

    fun map(adjustEvent: OsirisAdjustEvent) = AdjustEvent(adjustEvent.token).apply {
        adjustEvent.orderId?.let { orderId -> setOrderId(orderId) }
        adjustEvent.revenue?.let { revenueData -> setRevenue(revenueData.revenue, revenueData.currency) }
        adjustEvent.parameterizedData.forEach { data -> addParameter(data) }
        adjustEvent.criteoInject.forEach { criteoInjection -> injectEvent(criteoInjection) }
    }
}

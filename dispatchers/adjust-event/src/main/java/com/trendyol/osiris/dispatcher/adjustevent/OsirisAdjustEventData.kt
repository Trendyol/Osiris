package com.trendyol.osiris.dispatcher.adjustevent

import com.trendyol.osiris.EventData
import com.trendyol.osiris.dispatcher.adjustevent.criteo.CriteoInjection
import com.trendyol.osiris.dispatcher.adjustevent.data.AdjustParametrizedData
import com.trendyol.osiris.dispatcher.adjustevent.data.AdjustRevenue

data class OsirisAdjustEventData(
    val token: String,
    val parameterizedData: List<AdjustParametrizedData> = emptyList(),
    val criteoInject: List<CriteoInjection> = emptyList(),
    val orderId: String? = null,
    val revenue: AdjustRevenue? = null,
) : EventData

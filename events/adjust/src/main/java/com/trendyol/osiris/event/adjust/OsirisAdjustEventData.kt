package com.trendyol.osiris.event.adjust

import com.trendyol.osiris.EventData
import com.trendyol.osiris.event.adjust.criteo.CriteoInjection
import com.trendyol.osiris.event.adjust.data.AdjustParametrizedData
import com.trendyol.osiris.event.adjust.data.AdjustRevenue

data class OsirisAdjustEventData(
    val token: String,
    val parameterizedData: List<AdjustParametrizedData> = emptyList(),
    val criteoInject: List<CriteoInjection> = emptyList(),
    val orderId: String? = null,
    val revenue: AdjustRevenue? = null,
) : EventData

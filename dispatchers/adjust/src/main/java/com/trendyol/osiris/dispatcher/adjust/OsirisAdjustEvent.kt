package com.trendyol.osiris.dispatcher.adjust

import com.trendyol.osiris.Event
import com.trendyol.osiris.dispatcher.adjust.criteo.CriteoInjection
import com.trendyol.osiris.dispatcher.adjust.data.AdjustParametrizedData
import com.trendyol.osiris.dispatcher.adjust.data.AdjustRevenue

data class OsirisAdjustEvent(
    val token: String,
    val parameterizedData: List<AdjustParametrizedData> = emptyList(),
    val criteoInject: List<CriteoInjection> = emptyList(),
    val orderId: String? = null,
    val revenue: AdjustRevenue? = null,
) : Event()

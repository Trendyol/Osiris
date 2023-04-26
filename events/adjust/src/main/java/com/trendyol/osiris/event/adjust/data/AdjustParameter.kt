package com.trendyol.osiris.event.adjust.data

sealed class AdjustParameter(open val data: String) {
    data class Callback(override val data: String) : AdjustParameter(data)
    data class Partner(override val data: String) : AdjustParameter(data)
    data class PartnerAndCallback(override val data: String) : AdjustParameter(data)
}

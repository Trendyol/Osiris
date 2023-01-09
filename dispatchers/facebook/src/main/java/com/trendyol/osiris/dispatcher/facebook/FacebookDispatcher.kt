package com.trendyol.osiris.dispatcher.facebook

import android.content.Context
import android.os.Bundle
import androidx.core.os.bundleOf
import com.facebook.appevents.AppEventsLogger
import com.trendyol.osiris.Event
import com.trendyol.osiris.EventData
import com.trendyol.osiris.EventDispatcher
import java.math.BigDecimal
import java.util.Currency

class FacebookDispatcher(context: Context) : EventDispatcher {

    private val appEventsLogger: AppEventsLogger = AppEventsLogger.newLogger(context)

    override fun isSatisfied(event: Event<EventData>): Boolean {
        return event.data is FacebookEventDataContract
    }

    override fun logEvent(event: Event<EventData>) {
        val facebookEventData = event.data as FacebookEventDataContract
        val facebookEventParamsBundle = getEventParamsAsBundle(facebookEventData)

        when (facebookEventData) {
            is FacebookEventDataContract.FacebookEventData -> {
                appEventsLogger.logEvent(event.name, facebookEventParamsBundle)
            }
            is FacebookEventDataContract.FacebookPurchaseEventData -> {
                appEventsLogger.logPurchase(
                    BigDecimal.valueOf(facebookEventData.price ?: 0.0),
                    Currency.getInstance(facebookEventData.currency),
                    facebookEventParamsBundle
                )
            }
        }
    }

    private fun getEventParamsAsBundle(eventData: FacebookEventDataContract): Bundle {
        return eventData.params
            .map { it.key to it.value }
            .let { bundleOf(*it.toTypedArray()) }
    }
}

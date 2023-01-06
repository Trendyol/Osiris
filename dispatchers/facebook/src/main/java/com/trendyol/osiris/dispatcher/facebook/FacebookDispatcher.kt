package com.trendyol.osiris.dispatcher.facebook

import android.content.Context
import com.facebook.appevents.AppEventsLogger
import com.trendyol.osiris.Event
import com.trendyol.osiris.EventData
import com.trendyol.osiris.EventDispatcher
import com.trendyol.osiris.util.bundleOf
import java.math.BigDecimal
import java.util.Currency

class FacebookDispatcher(context: Context) : EventDispatcher {

    private val appEventsLogger: AppEventsLogger = AppEventsLogger.newLogger(context)

    override fun logEvent(event: Event<EventData>) {

        when (val facebookEvent = event.data as FacebookEventDataContract) {
            is FacebookEventDataContract.FacebookEventData -> {
                appEventsLogger.logEvent(event.name, bundleOf(facebookEvent.params))
            }
            is FacebookEventDataContract.FacebookPurchaseEventData -> {
                appEventsLogger.logPurchase(
                    BigDecimal.valueOf(facebookEvent.price),
                    Currency.getInstance(facebookEvent.currency),
                    bundleOf(facebookEvent.params)
                )
            }
        }
    }

    override fun isSatisfied(event: Event<EventData>): Boolean {
        return event.data is FacebookEventDataContract
    }
}

package com.trendyol.osiris.dispatcher.facebook

import android.content.Context
import com.facebook.appevents.AppEventsConstants
import com.facebook.appevents.AppEventsLogger
import com.trendyol.osiris.EventDispatcher
import com.trendyol.osiris.Event
import com.trendyol.osiris.EventData
import com.trendyol.osiris.util.bundleOf
import java.math.BigDecimal
import java.util.Currency

class FacebookDispatcher(context: Context) : EventDispatcher {

    private val appEventsLogger: AppEventsLogger = AppEventsLogger.newLogger(context)

    override fun logEvent(event: Event<EventData>) {
        val facebookEvent = event.data as com.trendyol.osiris.dispatcher.facebook.FacebookEvent

        if (event.name == AppEventsConstants.EVENT_NAME_PURCHASED) {
            appEventsLogger.logPurchase(
                BigDecimal.valueOf(facebookEvent.price),
                Currency.getInstance(facebookEvent.currency),
                bundleOf(facebookEvent.params),
            )
        } else {
            appEventsLogger.logEvent(
                event.name,
                bundleOf(facebookEvent.params),
            )
        }
    }

    override fun isSatisfied(event: Event<EventData>): Boolean {
        return event.data is com.trendyol.osiris.dispatcher.facebook.FacebookEvent
    }
}

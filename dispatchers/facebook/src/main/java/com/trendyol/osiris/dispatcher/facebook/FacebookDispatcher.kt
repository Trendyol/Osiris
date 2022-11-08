package com.trendyol.osiris.dispatcher.facebook

import android.content.Context
import com.facebook.appevents.AppEventsConstants
import com.facebook.appevents.AppEventsLogger
import com.trendyol.osiris.EventDispatcher
import com.trendyol.osiris.Event
import com.trendyol.osiris.EventData
import java.math.BigDecimal
import java.util.Currency

class FacebookDispatcher(context: Context) : EventDispatcher {

    private val appEventsLogger: AppEventsLogger = AppEventsLogger.newLogger(context)
    private val facebookEventMapper by lazy { FacebookEventMapper() }

    override fun logEvent(event: Event<EventData>) {
        val facebookEvent = event.data as FacebookEvent
        val facebookBundle = facebookEventMapper.map(facebookEvent)
        if (event.name == AppEventsConstants.EVENT_NAME_PURCHASED) {
            appEventsLogger.logPurchase(
                BigDecimal.valueOf(facebookEvent.price ?: 0.0),
                Currency.getInstance(facebookEvent.currency),
                facebookBundle
            )
        } else {
            appEventsLogger.logEvent(
                event.name,
                facebookBundle
            )
        }
    }

    override fun isSatisfied(event: Event<EventData>): Boolean {
        return event.data is FacebookEvent
    }
}

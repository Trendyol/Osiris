package com.trendyol.osiris.dispatcher.facebook

import android.content.Context
import com.facebook.appevents.AppEventsConstants
import com.facebook.appevents.AppEventsLogger
import com.trendyol.osiris.Dispatcher
import com.trendyol.osiris.Event
import java.math.BigDecimal
import java.util.Currency

class FacebookDispatcher(context: Context) : Dispatcher {

    private val appEventsLogger: AppEventsLogger = AppEventsLogger.newLogger(context)
    private val facebookEventMapper by lazy { FacebookEventMapper() }

    override fun logEvent(event: Event) {
        val facebookBundle = facebookEventMapper.map(event as FacebookEvent)
        if (event.name == AppEventsConstants.EVENT_NAME_PURCHASED) {
            appEventsLogger.logPurchase(
                BigDecimal.valueOf(event.price ?: 0.0),
                Currency.getInstance(event.currency),
                facebookBundle
            )
        } else {
            appEventsLogger.logEvent(
                event.name,
                facebookBundle
            )
        }
    }

    override fun isSatisfied(event: Event): Boolean {
        return event is FacebookEvent
    }
}

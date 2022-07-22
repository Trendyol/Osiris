package com.trendyol.osiris

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.adjust.sdk.AdjustConfig
import com.adjust.sdk.criteo.CriteoProduct
import com.trendyol.osiris.dispatcher.adjust.AdjustDispatcher
import com.trendyol.osiris.dispatcher.adjust.OsirisAdjustEvent
import com.trendyol.osiris.dispatcher.adjust.adjustParametrizedData
import com.trendyol.osiris.dispatcher.adjust.criteo.CriteoInjection
import com.trendyol.osiris.dispatcher.adjust.data.AdjustParameter
import com.trendyol.osiris.dispatcher.adjust.data.AdjustRevenue
import com.trendyol.osiris.dispatcher.facebook.FacebookDispatcher
import com.trendyol.osiris.dispatcher.facebook.FacebookEvent
import com.trendyol.osiris.dispatcher.firebase.FirebaseDispatcher
import com.trendyol.osiris.dispatcher.firebase.FirebaseEvent
import com.trendyol.osiris.dispatcher.newrelic.NewRelicDispatcher
import com.trendyol.osiris.dispatcher.newrelic.NewRelicEvent

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    private val osiris = Osiris()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        osiris.addDispatchers(
            getAdjustDispatcher(this),
            FirebaseDispatcher(),
            getFacebookDispatcher(this),
            NewRelicDispatcher()
        )

        osiris.addModifiers(
            ExampleEventModifier()
        )

        osiris.logEvents(
            buildAdjustEvent(),
            SeenEvent(),
            SampleFacebookEvent("Erol"),
            buildNewRelicEvent(),
        )
    }
}

private fun getAdjustDispatcher(context: Context): AdjustDispatcher {
    return AdjustDispatcher(AdjustConfig(context, "", ""))
}

private fun getFacebookDispatcher(context: Context): FacebookDispatcher {
    return FacebookDispatcher(context)
}

private fun buildAdjustEvent(): OsirisAdjustEvent {
    return OsirisAdjustEvent(
        token = "token",
        parameterizedData = listOf(
            adjustParametrizedData(key = "", adjustParameter = AdjustParameter.Partner("")),
            adjustParametrizedData(key = "", data = "")
        ),
        orderId = "12345",
        revenue = AdjustRevenue(10.0, "$"),
        criteoInject = listOf(
            CriteoInjection.UserSegment("visitor"),
            CriteoInjection.Cart(listOf(CriteoProduct(10F, 1, "123")))
        )
    )
}

private fun buildNewRelicEvent(): NewRelicEvent {
    val attributes = buildMap<String, Any> {
        put("screenName", "DeeplinkScreen")
        put("errorCode", "408")
        put("errorDescription", "RequestTimeout")
    }
    return NewRelicEvent("ResolveDeeplinkError", attributes)
}

class SeenEvent : FirebaseEvent("SeenEvent")

class SampleFacebookEvent(override val name: String) : FacebookEvent(name)

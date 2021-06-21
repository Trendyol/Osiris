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
import com.trendyol.osiris.dispatcher.firebase.FirebaseDispatcher
import com.trendyol.osiris.dispatcher.firebase.FirebaseEvent

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    private val osiris = Osiris()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val adjustDispatcher = getAdjustDispatcher(this)
        osiris.addDispatchers(adjustDispatcher, FirebaseDispatcher(this)).init()

        osiris.logEvents(buildAdjustEvent(), SeenEvent())
    }
}

private fun getAdjustDispatcher(context: Context): AdjustDispatcher {
    return AdjustDispatcher(AdjustConfig(context, "", ""))
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

class SeenEvent : FirebaseEvent("SeenEvent")

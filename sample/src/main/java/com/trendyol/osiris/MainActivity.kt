package com.trendyol.osiris

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.adjust.sdk.AdjustConfig
import com.trendyol.osiris.dispatcher.adjust.AdjustDispatcher
import com.trendyol.osiris.dispatcher.facebook.FacebookDispatcher
import com.trendyol.osiris.dispatcher.firebase.FirebaseDispatcher
import com.trendyol.osiris.dispatcher.newrelic.NewRelicDispatcher

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    private val osiris = Osiris()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        osiris.addDispatchers(
            AdjustDispatcher(AdjustConfig(this, "", "")),
            FirebaseDispatcher(),
            FacebookDispatcher(this),
            NewRelicDispatcher()
        )

        osiris.addModifiers(
            NewRelicEventModifier(),
            AdjustEventModifier(),
        )

        osiris.logEvents(HomeScreenSeenEventBuilder().build())

        osiris.logEvents(
            HomeScreenSeenEventBuilder(),
            HomeScreenSeenEventBuilder(),
        )
    }
}

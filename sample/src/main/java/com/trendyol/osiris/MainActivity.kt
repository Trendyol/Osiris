package com.trendyol.osiris

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.adjust.sdk.AdjustConfig
import com.trendyol.osiris.dispatcher.adjust.AdjustDispatcher
import com.trendyol.osiris.dispatcher.facebook.FacebookDispatcher
import com.trendyol.osiris.dispatcher.firebase.FirebaseDispatcher
import com.trendyol.osiris.dispatcher.newrelic.NewRelicDispatcher

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val osiris = Osiris.Builder()
            .dispatcher(
                AdjustDispatcher(AdjustConfig(this, "", "")),
                FirebaseDispatcher(),
                FacebookDispatcher(this),
                NewRelicDispatcher(),
            )
            .modifier(
                NewRelicEventModifier(),
                AdjustEventModifier(),
            )
            .build()

        osiris.logEvents(HomeScreenSeenEventBuilder().build())
    }
}

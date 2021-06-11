package com.trendyol.osiris

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.trendyol.osiris.dispatcher.adjust.AdjustDispatcher
import com.trendyol.osiris.dispatcher.adjust.AdjustEvent
import com.trendyol.osiris.dispatcher.firebase.FirebaseDispatcher
import com.trendyol.osiris.dispatcher.firebase.FirebaseEvent

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    private val osiris = Osiris()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        osiris.addDispatchers(
            AdjustDispatcher(),
            FirebaseDispatcher(this)
        )

        osiris.logEvents(
            ClickEvent(),
            SeenEvent()
        )
    }
}

class ClickEvent : AdjustEvent()

class SeenEvent : FirebaseEvent("SeenEvent")

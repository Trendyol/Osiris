package com.trendyol.osiris.dispatcher.firebase

import com.trendyol.osiris.EventData

data class FirebaseEvent(
    val params: Map<String, String>,
) : EventData

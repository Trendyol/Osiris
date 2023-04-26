package com.trendyol.osiris.event.firebase

import com.trendyol.osiris.EventData

data class FirebaseEventData(
    val params: Map<String, Any>,
) : EventData

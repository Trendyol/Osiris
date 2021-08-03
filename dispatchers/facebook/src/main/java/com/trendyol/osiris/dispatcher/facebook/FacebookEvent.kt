package com.trendyol.osiris.dispatcher.facebook

import android.os.Bundle
import com.trendyol.osiris.Event

open class FacebookEvent(
    override val name: String,
    val bundle: Bundle? = null,
    val currency: String? = null,
    val price: Double? = null
) : Event(name)

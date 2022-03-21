package com.trendyol.osiris.dispatcher.facebook

import android.os.Bundle
import androidx.core.os.bundleOf

class FacebookEventMapper {

    fun map(event: FacebookEvent): Bundle {
        val pairs = event.getData().map {
            it.key to it.value
        }
        return bundleOf(*pairs.toTypedArray())
    }
}

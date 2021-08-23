package com.trendyol.osiris.dispatcher.facebook

import android.os.Bundle

class FacebookEventMapper {

    fun map(facebookEvent: FacebookEvent): Bundle {
        val bundle = Bundle()
        facebookEvent.getData().map {
            bundle.putString(it.key, it.value.toString())
        }
        return bundle
    }
}

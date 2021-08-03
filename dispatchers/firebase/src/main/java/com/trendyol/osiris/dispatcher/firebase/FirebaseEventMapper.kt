package com.trendyol.osiris.dispatcher.firebase

import android.os.Bundle

class FirebaseEventMapper {

    fun map(event: FirebaseEvent): Bundle {
        val bundle = Bundle()
        event.getData().map {
            bundle.putString(it.key, it.value.toString())
        }
        return bundle
    }
}

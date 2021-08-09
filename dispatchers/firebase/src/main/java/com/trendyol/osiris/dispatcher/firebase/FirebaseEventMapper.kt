package com.trendyol.osiris.dispatcher.firebase

import android.os.Bundle
import androidx.core.os.bundleOf

class FirebaseEventMapper {

    fun map(event: FirebaseEvent): Bundle {
        val bundle = Bundle()
        event.getData().map {
            bundleOf(it.key to it.value)
        }
        return bundle
    }
}

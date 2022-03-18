package com.trendyol.osiris.dispatcher.firebase

import android.os.Bundle
import androidx.core.os.bundleOf

class FirebaseEventMapper {

    fun map(event: FirebaseEvent): Bundle {
        val pairs = event.getData().map {
            it.key to it.value
        }
        return bundleOf(*pairs.toTypedArray())
    }
}

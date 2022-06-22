package com.trendyol.osiris.dispatcher.firebase

import android.os.Bundle
import com.trendyol.osiris.util.bundleOf

class FirebaseEventMapper {

    fun map(event: FirebaseEvent): Bundle {
        return bundleOf(event.getData())
    }
}

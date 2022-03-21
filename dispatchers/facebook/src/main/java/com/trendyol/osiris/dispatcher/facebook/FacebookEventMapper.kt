package com.trendyol.osiris.dispatcher.facebook

import android.os.Bundle
import com.trendyol.osiris.util.bundleOf

class FacebookEventMapper {

    fun map(event: FacebookEvent): Bundle {
        return bundleOf(event.getData())
    }
}

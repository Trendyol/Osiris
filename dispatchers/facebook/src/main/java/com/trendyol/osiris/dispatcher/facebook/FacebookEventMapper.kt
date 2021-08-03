package com.trendyol.osiris.dispatcher.facebook

import android.os.Bundle
import android.os.Parcelable
import java.util.ArrayList

class FacebookEventMapper {

    fun map(facebookEvent: FacebookEvent): Bundle {
        val bundle = Bundle()
        facebookEvent.getData().entries.forEach {
            when (it.value) {
                is Bundle -> bundle.putBundle(it.key, it.value as Bundle)
                is Byte -> bundle.putByte(it.key, it.value as Byte)
                is Char -> bundle.putChar(it.key, it.value as Char)
                is CharSequence -> bundle.putCharSequence(it.key, it.value as CharSequence)
                is Int -> bundle.putInt(it.key, it.value as Int)
                is Float -> bundle.putFloat(it.key, it.value as Float)
                is Double -> bundle.putDouble(it.key, it.value as Double)
                is Parcelable -> bundle.putParcelable(it.key, it.value as Parcelable)
                is Map<*, *> -> {
                    val listOfBundles = mutableListOf<Bundle>()
                    listOfBundles.add(map(FacebookEvent("", it.value as Bundle, null, null)))
                    bundle.putParcelableArrayList(it.key, listOfBundles as ArrayList<out Parcelable>)
                }
                else -> throw IllegalArgumentException()
            }
        }
        return bundle
    }
}

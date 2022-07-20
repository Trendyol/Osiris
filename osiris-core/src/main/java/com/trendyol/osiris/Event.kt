package com.trendyol.osiris

abstract class Event(open val name: String = "") {

    private val params = mutableMapOf<String, Any>()

    fun add(key: String, value: Any): Event {
        params[key] = value
        return this
    }

    fun addAll(map: Map<String, Any>): Event {
        params.putAll(map)
        return this
    }

    fun getData(): Map<String, Any> {
        return params
    }
}

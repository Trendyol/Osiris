package com.trendyol.osiris

abstract class Event(val name: String = "") {

    private val params = mutableMapOf<String, Any>()

    fun add(key: String, value: Any) {
        params[key] = value
    }

    fun addAll(map: Map<String, Any>) {
        params.putAll(map)
    }

    fun getData(): Map<String, Any> {
        return params
    }
}

package com.trendyol.osiris

data class Event<out T : EventData>(
    val name: String,
    val data: T,
)

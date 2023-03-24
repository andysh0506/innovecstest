package io.ashpak.test.domain.model

data class Event(
    var uid: Long = 0,
    val bootCount: Long,
    val lastTime: Long
)

package io.ashpak.test.data.model.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import io.ashpak.test.domain.model.Event

@Entity
data class EventDB(
    @PrimaryKey(autoGenerate = true)
    var uid: Long,
    val bootCount: Long,
    val lastTime: Long
) {
    fun toEvent(): Event = Event( uid, bootCount,lastTime)

    companion object {
        fun fromEvent(event: Event): EventDB {
           return EventDB(uid = event.uid, bootCount = event.bootCount, lastTime = event.lastTime)
        }
    }
}


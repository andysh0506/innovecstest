package io.ashpak.test.domain.repositories

import io.ashpak.test.domain.model.Event
import kotlinx.coroutines.flow.Flow

interface EventRepository {

    val events: Flow<List<Event>>

    suspend fun insert(event: Event):Long

    suspend fun update(event: Event)
}

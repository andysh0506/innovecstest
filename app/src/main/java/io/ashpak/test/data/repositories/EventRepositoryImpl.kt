/*
 * Copyright (C) 2022 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.ashpak.test.data.repositories

import io.ashpak.test.data.local.database.EventDao
import io.ashpak.test.data.model.local.EventDB
import io.ashpak.test.domain.model.Event
import io.ashpak.test.domain.repositories.EventRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class EventRepositoryImpl @Inject constructor(
    private val eventDao: EventDao
) : EventRepository {

    override val events: Flow<List<Event>> get() =  eventDao.getEvents().map { items -> items.map { it.toEvent() } }

    override suspend fun insert(event: Event):Long {
        return eventDao.insertEvent(EventDB.fromEvent(event))
    }

    override suspend fun update(event: Event) {
        eventDao.updateEvent(EventDB.fromEvent(event))
    }
}

package com.omk.ict.virginmoney.repository

import com.omk.ict.virginmoney.model.data.people.People
import com.omk.ict.virginmoney.model.data.room.Room
import retrofit2.Response

interface Repository {

    suspend fun getPeople(): Response<People>
    suspend fun getRoom(): Response<Room>
}
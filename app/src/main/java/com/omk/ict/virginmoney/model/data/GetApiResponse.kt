package com.omk.ict.virginmoney.model.data

import com.omk.ict.virginmoney.model.data.people.People
import com.omk.ict.virginmoney.model.data.room.Room
import retrofit2.Response
import retrofit2.http.GET

interface GetApiResponse {
    @GET(ApiDetails.PEOPLE) //to define type of request GET, POST, PUT
    suspend fun getPeople(): Response<People>

    @GET(ApiDetails.ROOM) //to define type of request GET, POST, PUT
    suspend fun getRoom(): Response<Room>
}
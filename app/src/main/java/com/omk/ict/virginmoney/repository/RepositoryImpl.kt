package com.omk.ict.virginmoney.repository

import com.omk.ict.virginmoney.model.data.ApiDetails
import com.omk.ict.virginmoney.model.data.GetApiResponse
import javax.inject.Inject


class RepositoryImpl @Inject constructor (
    private val apiDetails: GetApiResponse
    ) : Repository {
    override suspend fun getPeople() = apiDetails.getPeople()

    override suspend fun getRoom() = apiDetails.getRoom()
    }
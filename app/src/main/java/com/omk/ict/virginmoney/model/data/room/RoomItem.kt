package com.omk.ict.virginmoney.model.data.room


import com.google.gson.annotations.SerializedName

data class RoomItem(
    @SerializedName("createdAt")
    val createdAtModel: String = "",
    @SerializedName("id")
    val idModel: String = "",
    @SerializedName("isOccupied")
    val isOccupiedModel: Boolean = false,
    @SerializedName("maxOccupancy")
    val maxOccupancyModel: Int = 0
)
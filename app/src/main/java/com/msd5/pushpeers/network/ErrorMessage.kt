package com.msd5.pushpeers.network


import com.google.gson.annotations.SerializedName

data class ErrorMessage(
    @SerializedName("error", alternate = ["message"])
    val message: String,

    @SerializedName("status")
    val success: Boolean
){


}
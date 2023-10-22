package com.msd5.pushpeers.utils

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.msd5.pushpeers.utils.Resource.Status.*
import kotlinx.coroutines.Dispatchers

fun <T> performGetOperation(networkCall: suspend () -> Resource<T>): LiveData<Resource<T>> =
    liveData(Dispatchers.IO) {
        emit(Resource.loading())
        val responseStatus = networkCall.invoke()
        if (responseStatus.status == SUCCESS) {
            emit(responseStatus)

        } else if (responseStatus.status == ERROR) {
            emit(Resource.error(responseStatus.message!!))
        }
    }
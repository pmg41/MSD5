package com.msd5.pushpeers.network

import android.content.Context
import com.msd5.pushpeers.utils.SharedPreferenceManager
import javax.inject.Inject

class ApiDataSource @Inject constructor(
    private val apiServices: ApiServices,
    private val sharedPreferenceManager: SharedPreferenceManager,
    private val context: Context
) : BaseDataSource(context) {


}
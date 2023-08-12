package com.hugidonic.data.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class ApiFactory {

    val scheduleApi: ApiService = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BASE_URL)
        .build()
        .create()

    companion object {
        const val BASE_URL = "https://scheduler-api.vercel.app"
    }
}
package com.hugidonic.data.remote

import retrofit2.http.GET

interface ApiService {

    suspend fun getSchedule()
}
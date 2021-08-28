package com.opskube.myapplication.Network

import com.opskube.myapplication.RecyclerData
import com.opskube.myapplication.RecyclerList
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface RetroService {

    @GET("posts")
    suspend fun getDataFromApi():RecyclerList
}
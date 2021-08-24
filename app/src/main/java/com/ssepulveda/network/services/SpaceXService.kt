package com.ssepulveda.network.services

import com.ssepulveda.network.models.HistoryResponse
import com.ssepulveda.network.models.RocketsResponse
import retrofit2.Response
import retrofit2.http.GET

interface SpaceXService {

    @GET("History")
    suspend fun getHistory(): Response<List<HistoryResponse>>

    @GET("rockets")
    suspend fun getRockets(): Response<List<RocketsResponse>>

}
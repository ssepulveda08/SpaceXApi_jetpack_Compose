package com.ssepulveda.network.api

import com.ssepulveda.network.models.HistoryResponse
import com.ssepulveda.network.models.RocketsResponse
import retrofit2.Response

interface SpaceXApi {

    suspend fun getHistory(): Response<List<HistoryResponse>>

    suspend fun getRockets(): Response<List<RocketsResponse>>

}
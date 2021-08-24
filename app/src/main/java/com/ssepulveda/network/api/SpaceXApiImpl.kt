package com.ssepulveda.network.api

import com.ssepulveda.network.models.HistoryResponse
import com.ssepulveda.network.models.RocketsResponse
import com.ssepulveda.network.services.SpaceXService
import retrofit2.Response
import javax.inject.Inject

class SpaceXApiImpl @Inject constructor(
    private val spaceXService: SpaceXService
): SpaceXApi{

    override suspend fun getHistory(): Response<List<HistoryResponse>> = spaceXService.getHistory()

    override suspend fun getRockets(): Response<List<RocketsResponse>> = spaceXService.getRockets()
}
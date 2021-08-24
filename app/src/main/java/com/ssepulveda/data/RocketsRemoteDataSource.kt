package com.ssepulveda.data

import com.ssepulveda.network.models.RocketsResponse
import com.ssepulveda.network.services.SpaceXService
import retrofit2.Response
import javax.inject.Inject

class RocketsRemoteDataSource @Inject constructor(
    private val spaceXService: SpaceXService
) {

     suspend fun getRockets(): Response<List<RocketsResponse>> = spaceXService.getRockets()
}

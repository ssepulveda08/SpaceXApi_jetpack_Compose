package com.ssepulveda.data

import com.ssepulveda.network.models.HistoryResponse
import com.ssepulveda.network.services.SpaceXService
import retrofit2.Response
import javax.inject.Inject

class HistoryRemoteDataSource @Inject constructor(
    private val spaceXService: SpaceXService
) : HistoryDataSource {

    override suspend fun getHistory(): Response<List<HistoryResponse>> = spaceXService.getHistory()
}

package com.ssepulveda.data

import com.ssepulveda.network.models.HistoryResponse
import retrofit2.Response

interface HistoryDataSource {
    suspend fun getHistory(): Response<List<HistoryResponse>>
}
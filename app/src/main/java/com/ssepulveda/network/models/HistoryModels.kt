package com.ssepulveda.network.models

import com.google.gson.annotations.SerializedName

data class HistoryResponse(
    @SerializedName("links") val links: Links,
    @SerializedName("title") val title: String,
    @SerializedName("event_date_utc") val event_date_utc: String,
    @SerializedName("event_date_unix") val event_date_unix: Int,
    @SerializedName("details") val details: String,
    @SerializedName("id") val id: String
)

data class Links(
    @SerializedName("article") val article: String
)
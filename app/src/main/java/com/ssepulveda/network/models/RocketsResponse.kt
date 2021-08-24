package com.ssepulveda.network.models

import com.google.gson.annotations.SerializedName

data class RocketsResponse (
    @SerializedName("height") val height : Height,
    @SerializedName("diameter") val diameter : Diameter,
    @SerializedName("mass") val mass : Mass,
    @SerializedName("first_stage") val first_stage : FirstStage,
    @SerializedName("second_stage") val second_stage : SecondStage,
    @SerializedName("engines") val engines : Engines,
    @SerializedName("landing_legs") val landing_legs : LandingLegs,
    @SerializedName("payload_weights") val payload_weights : List<PayloadWeights>,
    @SerializedName("flickr_images") val flickr_images : List<String>,
    @SerializedName("name") val name : String,
    @SerializedName("type") val type : String,
    @SerializedName("active") val active : Boolean,
    @SerializedName("stages") val stages : Int,
    @SerializedName("boosters") val boosters : Int,
    @SerializedName("cost_per_launch") val cost_per_launch : Int,
    @SerializedName("success_rate_pct") val success_rate_pct : Int,
    @SerializedName("first_flight") val first_flight : String,
    @SerializedName("country") val country : String,
    @SerializedName("company") val company : String,
    @SerializedName("wikipedia") val wikipedia : String,
    @SerializedName("description") val description : String,
    @SerializedName("id") val id : String
)

data class Diameter (
    @SerializedName("meters") val meters : Double,
    @SerializedName("feet") val feet : Double
)

data class Engines (
    @SerializedName("isp") val isp : Isp,
    @SerializedName("number") val number : Int,
    @SerializedName("type") val type : String,
    @SerializedName("version") val version : String,
    @SerializedName("layout") val layout : String,
    @SerializedName("engine_loss_max") val engine_loss_max : Int,
    @SerializedName("propellant_1") val propellant_1 : String,
    @SerializedName("propellant_2") val propellant_2 : String,
)

data class Isp (
    @SerializedName("sea_level") val sea_level : Int,
    @SerializedName("vacuum") val vacuum : Int
)

data class PayloadWeights (
    @SerializedName("id") val id : String,
    @SerializedName("name") val name : String,
    @SerializedName("kg") val kg : Int,
    @SerializedName("lb") val lb : Int
)

data class Mass (
    @SerializedName("kg") val kg : Int,
    @SerializedName("lb") val lb : Int
)

data class FirstStage (
    @SerializedName("reusable") val reusable : Boolean,
    @SerializedName("engines") val engines : Int,
    @SerializedName("fuel_amount_tons") val fuel_amount_tons : Double,
    @SerializedName("burn_time_sec") val burn_time_sec : Int
)

data class Payloads (
    @SerializedName("option_1") val option_1 : String
)


data class SecondStage (
    @SerializedName("payloads") val payloads : Payloads,
    @SerializedName("reusable") val reusable : Boolean,
    @SerializedName("engines") val engines : Int,
    @SerializedName("fuel_amount_tons") val fuel_amount_tons : Double,
    @SerializedName("burn_time_sec") val burn_time_sec : Int
)

data class ThrustVacuum (
    @SerializedName("kN") val kN : Int,
    @SerializedName("lbf") val lbf : Int
)

data class LandingLegs (
    @SerializedName("number") val number : Int,
    @SerializedName("material") val material : String
)

data class Height (
    @SerializedName("meters") val meters : Double,
    @SerializedName("feet") val feet : Double
)
package com.tilak.apps.moshi.data.model

import com.squareup.moshi.Json

data class AirlineModel(
    @Json(name = "__clazz")
    val __clazz: String,
    @Json(name = "code")
    val code: String,
    @Json(name = "defaultName")
    val defaultName: String,
    @Json(name = "logoURL")
    val logoURL: String,
    @Json(name = "name")
    val name: String,
    @Json(name = "phone")
    val phone: String,
    @Json(name = "site")
    val site: String,
    @Json(name = "usName")
    val usName: String
)

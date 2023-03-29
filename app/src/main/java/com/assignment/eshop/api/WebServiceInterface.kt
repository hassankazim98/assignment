package com.assignment.eshop.api

import com.assignment.eshop.data.db.model.ProductListModel
import com.google.gson.JsonObject

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

/**
 * REST API access points
 */
interface WebServiceInterface {

    @GET("search.php?s")
    suspend fun callProducts(): Response<ProductListModel>

    @GET("search.php?s")
    suspend fun callSearch(@Body jsonObject: JsonObject): Response<ProductListModel>

}
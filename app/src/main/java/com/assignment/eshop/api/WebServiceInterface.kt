package com.assignment.eshop.api

import com.assignment.eshop.data.db.model.AllProductModel
import com.assignment.eshop.data.db.model.Product
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * REST API access points
 */
interface WebServiceInterface {

    @GET("lookup.php")
    suspend fun callSearchProducts(@Query("i") id:Int): Response<Product>

    @GET("latest.php")
    suspend fun getMeals(): AllProductModel

    //https://www.themealdb.com/api/json/v1/1/lookup.php?i=52977
    //https://www.quotes.io/quotes?page=1

}
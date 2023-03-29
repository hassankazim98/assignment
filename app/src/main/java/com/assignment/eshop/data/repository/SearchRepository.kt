package com.assignment.eshop.data.repository

import com.assignment.eshop.api.SafeAPIRequest
import com.assignment.eshop.api.WebServiceInterface
import com.assignment.eshop.data.db.model.ProductListModel
import com.google.gson.JsonObject
import javax.inject.Inject

class SearchRepository  @Inject constructor(
    private val webServiceInterface: WebServiceInterface
) : SafeAPIRequest() {

    suspend fun callSearch(jsonObject: JsonObject): ProductListModel {
        return apiRequest {
            webServiceInterface.callSearch(jsonObject)
        }
    }


}
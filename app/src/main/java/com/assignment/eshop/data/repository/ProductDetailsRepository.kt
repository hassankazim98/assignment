package com.assignment.eshop.data.repository

import com.assignment.eshop.api.WebServiceInterface
import com.assignment.eshop.api.SafeAPIRequest
import com.assignment.eshop.data.db.model.ProductListModel
import com.google.gson.JsonObject
import javax.inject.Inject

class ProductDetailsRepository  @Inject constructor(
    private val webServiceInterface: WebServiceInterface
) : SafeAPIRequest() {



}
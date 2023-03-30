package com.assignment.eshop.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.assignment.eshop.api.WebServiceInterface
import com.assignment.eshop.api.SafeAPIRequest
import com.assignment.eshop.data.db.model.AllProductModel
import com.assignment.eshop.data.db.model.Product
import com.assignment.eshop.data.db.model.ProductListModel
import com.google.gson.JsonObject
import retrofit2.Retrofit
import javax.inject.Inject

class HomeRepository  @Inject constructor(
    private val webServiceInterface: WebServiceInterface
) : SafeAPIRequest() {

    private val productLiveData = MutableLiveData<Product>()
    val products : LiveData<Product>
    get()= productLiveData

    suspend fun getAllproduct(id:Int){
     val result = webServiceInterface.callSearchProducts(id)

     if (result.body() !=null ){
            productLiveData.postValue(result.body())
     }
 }

}
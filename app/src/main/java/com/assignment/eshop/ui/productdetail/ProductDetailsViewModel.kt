package com.assignment.eshop.ui.productdetail

import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.assignment.eshop.MyApp
import com.assignment.eshop.api.ApiExceptions
import com.assignment.eshop.api.NoInternetException
import com.assignment.eshop.data.db.model.ProductListModel
import com.assignment.eshop.data.repository.ProductDetailsRepository
import com.assignment.eshop.utils.*
import com.google.gson.JsonObject
import org.json.JSONObject
import javax.inject.Inject

class ProductDetailsViewModel @Inject constructor(
    private val application: MyApp,
    private val repository: ProductDetailsRepository
) : AndroidViewModel(application) {

    private val _isViewLoading = MutableLiveData<Boolean>()
    val isViewLoading: LiveData<Boolean> get() = _isViewLoading

    private val _onMessageError = MutableLiveData<Any>()
    val onMessageError: LiveData<Any> get() = _onMessageError

    private val _productDetailsModel: MutableLiveData<ProductListModel> =
        MutableLiveData<ProductListModel>()
    val productDetailsModel: LiveData<ProductListModel>
        get() = _productDetailsModel



    fun callProductDetails(productid: Int) {
        Coroutines.main {
            try {
                val inputParam = JsonObject()
              //  inputParam.addProperty(Constant.REQUEST_PRODUCT_ID, productid)
                _isViewLoading.postValue(true)
                //val apiResponse = repository.callProductDetails(inputParam)
                _isViewLoading.postValue(false)
                /*if (apiResponse.data.size > 0) {
                    _productDetailsModel.postValue(apiResponse.data.get(0))
                }*/
            } catch (e: ApiExceptions) {
                _isViewLoading.postValue(false)
                _onMessageError.postValue(e.message)
            } catch (e: NoInternetException) {
                _isViewLoading.postValue(false)
                _onMessageError.postValue(e.message)
            }
        }
    }

}


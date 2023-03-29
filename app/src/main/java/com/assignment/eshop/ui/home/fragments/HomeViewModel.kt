package com.assignment.eshop.ui.home.fragments

import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.assignment.eshop.MyApp
import com.assignment.eshop.api.ApiExceptions
import com.assignment.eshop.api.NoInternetException
import com.assignment.eshop.data.db.model.ProductListModel
import com.assignment.eshop.data.repository.HomeRepository
import com.assignment.eshop.utils.Constant
import com.assignment.eshop.utils.Coroutines
import com.assignment.eshop.utils.LogM
import com.google.gson.JsonObject
import javax.inject.Inject

class HomeViewModel @Inject constructor(
    private val application: MyApp,
    private val repository: HomeRepository
) : AndroidViewModel(application) {

    private val _isViewLoading = MutableLiveData<Boolean>()
    val isViewLoading: LiveData<Boolean> get() = _isViewLoading

    private val _onMessageError = MutableLiveData<Any>()
    val onMessageError: LiveData<Any> get() = _onMessageError


    private val _allProduct: MutableLiveData<ProductListModel> =
        MutableLiveData<ProductListModel>()
    val product: LiveData<ProductListModel>
        get() = _allProduct

    init {
        callAllProducts()
    }

        fun callAllProducts(): LiveData<ProductListModel> {
        Coroutines.main {
            try {
                _isViewLoading.postValue(true)
                val apiResponse = repository.callProducts()
                _isViewLoading.postValue(false)
                _allProduct.postValue(apiResponse)
                _isViewLoading.postValue(false)
                _allProduct.postValue(apiResponse)
            } catch (e: ApiExceptions) {
                _isViewLoading.postValue(false)
                _onMessageError.postValue(e.message)
            } catch (e: NoInternetException) {
                _isViewLoading.postValue(false)
                _onMessageError.postValue(e.message)
            }
        }
            return _allProduct
        }

}

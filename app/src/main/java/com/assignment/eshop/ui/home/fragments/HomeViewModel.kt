package com.assignment.eshop.ui.home.fragments

import androidx.lifecycle.*
import com.assignment.eshop.MyApp
import com.assignment.eshop.api.ApiExceptions
import com.assignment.eshop.api.NoInternetException
import com.assignment.eshop.data.db.model.AllProductModel
import com.assignment.eshop.data.db.model.Product
import com.assignment.eshop.data.db.model.ProductListModel
import com.assignment.eshop.data.repository.HomeRepository
import com.assignment.eshop.utils.Constant
import com.assignment.eshop.utils.Coroutines
import com.assignment.eshop.utils.LogM
import com.google.gson.JsonObject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import okhttp3.Dispatcher
import javax.inject.Inject

class HomeViewModel @Inject constructor(private val repository: HomeRepository)
    : ViewModel()
{

    init {
        viewModelScope.launch(Dispatchers.IO){
            repository.getAllproduct(1)
        }
        LogM.e("==> viewmodel data "+products.value.toString())
    }

    val products : LiveData<Product>
        get() = repository.products

}

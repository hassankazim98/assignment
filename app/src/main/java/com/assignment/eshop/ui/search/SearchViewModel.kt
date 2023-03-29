package com.assignment.eshop.ui.search

import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.assignment.eshop.MyApp
import com.assignment.eshop.api.ApiExceptions
import com.assignment.eshop.api.NoInternetException
import com.assignment.eshop.data.db.model.ProductListModel
import com.assignment.eshop.data.repository.SearchRepository
import com.assignment.eshop.utils.Constant
import com.assignment.eshop.utils.Coroutines
import com.assignment.eshop.utils.toast
import com.google.gson.JsonObject
import javax.inject.Inject

class SearchViewModel @Inject constructor(
    private val application: MyApp,
    private val repository: SearchRepository,
) : AndroidViewModel(application) {

    private val _isViewLoading = MutableLiveData<Boolean>()
    val isViewLoading: LiveData<Boolean> get() = _isViewLoading

    private val _onMessageError = MutableLiveData<Any>()
    val onMessageError: LiveData<Any> get() = _onMessageError


    private val _searchText: MutableLiveData<String> =
        MutableLiveData<String>()
    val searchText: LiveData<String>
        get() = _searchText

    private val _searchList: MutableLiveData<ProductListModel> =
        MutableLiveData<ProductListModel>()
    val searchList: LiveData<ProductListModel>
        get() = _searchList

    fun setSearchData(text: String){
      _searchText.postValue(text)
    }

    fun callSearch(searchText : String): LiveData<ProductListModel> {
        Coroutines.main {
            try {
                _isViewLoading.postValue(true)
//                val apiResponse = repository.callSearch()
                _isViewLoading.postValue(false)
                //_searchList.postValue(apiResponse)
                _isViewLoading.postValue(false)
  //              _searchList.postValue(apiResponse)
            } catch (e: ApiExceptions) {
                _isViewLoading.postValue(false)
                _onMessageError.postValue(e.message)
            } catch (e: NoInternetException) {
                _isViewLoading.postValue(false)
                _onMessageError.postValue(e.message)
            }
        }
        return _searchList
    }



}
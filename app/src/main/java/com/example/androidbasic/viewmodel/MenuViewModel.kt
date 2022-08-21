package com.example.androidbasic.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidbasic.model.Product
import com.example.androidbasic.model.withrelations.ProductWithRelations
import com.example.androidbasic.repository.ProductRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MenuViewModel : ViewModel() {

    private val repository = ProductRepository()

    private val categoryListMutableLiveData = MutableLiveData<List<ProductWithRelations>>()
    private val toastMutableLiveData = MutableLiveData<String>()

    val categoryListLiveData: LiveData<List<ProductWithRelations>>
        get() = categoryListMutableLiveData

    val toastLiveData: LiveData<String>
        get() = toastMutableLiveData

    fun getProductWithRelations() {
        viewModelScope.launch(Dispatchers.IO) {
            categoryListMutableLiveData.postValue(repository.getProductWithRelations())
        }
    }

    fun insertProduct(product: Product) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.insertProduct(product)
        }
    }

}
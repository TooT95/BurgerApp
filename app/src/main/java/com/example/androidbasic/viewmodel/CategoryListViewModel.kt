package com.example.androidbasic.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidbasic.model.Category
import com.example.androidbasic.repository.CategoryRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CategoryListViewModel : ViewModel() {

    private val repository = CategoryRepository()
    private val categoryListMutableLiveData = MutableLiveData<List<Category>>()
    private val toastMutableLiveData = MutableLiveData<String>()

    val categoryListLiveData: LiveData<List<Category>>
        get() = categoryListMutableLiveData

    val toastLiveData: LiveData<String>
        get() = toastMutableLiveData

    fun getCategoryList() {
        viewModelScope.launch(Dispatchers.IO) {
            categoryListMutableLiveData.postValue(repository.getCategoryList())
        }
    }

    fun insertCategory(category: Category) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.insertCategory(category)
        }
    }
}
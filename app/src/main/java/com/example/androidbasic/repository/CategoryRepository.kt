package com.example.androidbasic.repository

import com.example.androidbasic.model.Category
import com.example.androidbasic.database.DatabaseInit

class CategoryRepository {

    private val dao = DatabaseInit.db.categoryDao()

    suspend fun getCategoryList(): List<Category> {
        return dao.getCategoryList()
    }

    suspend fun insertCategory(category: Category) {
        dao.insertCategory(category)
    }

}
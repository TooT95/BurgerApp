package com.example.androidbasic.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.androidbasic.model.Category
import com.example.androidbasic.model.contract.CategoryContract

@Dao
interface CategoryDao {

    companion object {
        const val IS_ACTIVE = true
    }

    @Query("SELECT * FROM ${CategoryContract.TABLE_NAME} WHERE ${CategoryContract.Columns.IS_ACTIVE} = $IS_ACTIVE")
    fun getCategoryList(): List<Category>

    @Insert
    fun insertCategory(category: Category)

}
package com.example.androidbasic.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.androidbasic.model.Product
import com.example.androidbasic.model.contract.CategoryContract
import com.example.androidbasic.model.withrelations.ProductWithRelations

@Dao
interface ProductDao {

    @Query("SELECT * FROM ${CategoryContract.TABLE_NAME} WHERE ${CategoryContract.Columns.IS_ACTIVE} = ${CategoryDao.IS_ACTIVE}")
    fun getProductWithRelations(): List<ProductWithRelations>

    @Insert
    fun insertProduct(product: Product)

}
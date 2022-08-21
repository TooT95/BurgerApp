package com.example.androidbasic.repository

import com.example.androidbasic.database.DatabaseInit
import com.example.androidbasic.model.Product
import com.example.androidbasic.model.withrelations.ProductWithRelations

class ProductRepository {

    private val dao = DatabaseInit.db.productDao()

    suspend fun getProductWithRelations(): List<ProductWithRelations> {
        return dao.getProductWithRelations()
    }

    suspend fun insertProduct(product: Product) {
        dao.insertProduct(product)
    }

}
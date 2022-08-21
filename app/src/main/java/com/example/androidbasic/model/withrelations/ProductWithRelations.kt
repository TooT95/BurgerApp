package com.example.androidbasic.model.withrelations

import androidx.room.Embedded
import androidx.room.Relation
import com.example.androidbasic.model.Category
import com.example.androidbasic.model.Product
import com.example.androidbasic.model.contract.CategoryContract
import com.example.androidbasic.model.contract.ProductContract

data class ProductWithRelations(
    @Embedded
    val category: Category,
    @Relation(
        parentColumn = CategoryContract.Columns.ID,
        entityColumn = ProductContract.Columns.CATEGORY_ID
    )
    val productList: List<Product>
)
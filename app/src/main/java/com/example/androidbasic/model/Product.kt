package com.example.androidbasic.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.example.androidbasic.model.contract.CategoryContract
import com.example.androidbasic.model.contract.ProductContract

@Entity(
    tableName = ProductContract.TABLE_NAME, foreignKeys = [
        ForeignKey(
            entity = Category::class,
            parentColumns = [CategoryContract.Columns.ID],
            childColumns = [ProductContract.Columns.CATEGORY_ID]
        )
    ]
)
data class Product(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = ProductContract.Columns.ID)
    val id: Long = 0,
    @ColumnInfo(name = ProductContract.Columns.NAME)
    val name: String,
    @ColumnInfo(name = ProductContract.Columns.CATEGORY_ID)
    val categoryId: Long,
    @ColumnInfo(name = ProductContract.Columns.PRICE)
    val price: Float,
    @ColumnInfo(name = ProductContract.Columns.IMAGE_URL)
    val imageUrl: String,
    @ColumnInfo(name = ProductContract.Columns.DESCRIPTION)
    val description: String
)

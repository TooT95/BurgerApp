package com.example.androidbasic.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.androidbasic.model.contract.CategoryContract

@Entity(tableName = CategoryContract.TABLE_NAME)
data class Category(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = CategoryContract.Columns.ID)
    val id: Long = 0,
    @ColumnInfo(name = CategoryContract.Columns.NAME)
    val name: String,
    @ColumnInfo(name = CategoryContract.Columns.IS_ACTIVE)
    val isActive: Boolean = true
)

package com.example.androidbasic.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.androidbasic.model.Category
import com.example.androidbasic.database.dao.CategoryDao
import com.example.androidbasic.database.dao.ProductDao
import com.example.androidbasic.model.Product

@Database(
    entities = [
        Category::class,
        Product::class
    ], version = BurgerDatabase.DATABASE_VERSION
)
abstract class BurgerDatabase : RoomDatabase() {

    abstract fun categoryDao(): CategoryDao
    abstract fun productDao(): ProductDao

    companion object {
        const val DATABASE_VERSION = 1
        const val DATABASE_NAME = "burger_database"
    }
}
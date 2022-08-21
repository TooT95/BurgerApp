package com.example.androidbasic.model.contract

object ProductContract {

    const val TABLE_NAME = "products"

    object Columns {
        const val ID = "id"
        const val NAME = "name"
        const val CATEGORY_ID = "category_id"
        const val PRICE = "price"
        const val IMAGE_URL = "image_url"
        const val DESCRIPTION = "description"
    }
}
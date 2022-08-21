package com.example.androidbasic.database

import android.content.Context
import androidx.room.Room

object DatabaseInit {

    lateinit var db: BurgerDatabase
        private set

    fun init(context: Context) {
        db = Room.databaseBuilder(context, BurgerDatabase::class.java, BurgerDatabase.DATABASE_NAME)
            .build()
    }

}
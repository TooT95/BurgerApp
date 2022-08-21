package com.example.androidbasic

import android.app.Application
import com.example.androidbasic.database.DatabaseInit

class BurgerApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        DatabaseInit.init(this)
    }

}
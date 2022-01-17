package com.example.angelatest.application

import android.app.Application
import com.example.angelatest.ui.home.repo.HomeRepo
import com.example.angelatest.room.AppDatabase

class Application :Application()  {

    val database by lazy { AppDatabase.getDatabaseClient(this) }
    val  repo by lazy { HomeRepo(database.loginDao()) }



    companion object {
        private var instance: com.example.angelatest.application.Application? = null
        fun getInstance() : com.example.angelatest.application.Application {
            return instance as com.example.angelatest.application.Application
        }
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }

}
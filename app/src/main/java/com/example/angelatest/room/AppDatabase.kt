package com.example.angelatest.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.angelatest.data.User

@Database(entities = [User::class],version = 1,exportSchema = false)
 abstract class AppDatabase :RoomDatabase(){

    abstract fun loginDao(): DAOLogin

    companion object{
        @Volatile
        private var INSTANCE:AppDatabase?=null
        fun getDatabaseClient(context:Context):AppDatabase{
            if(INSTANCE!=null){
                return INSTANCE!!
            }
            synchronized(this){
                INSTANCE= Room.databaseBuilder(context,AppDatabase::class.java,"app_db")
                    .fallbackToDestructiveMigration()
                    .build()

                return INSTANCE!!
            }
        }
    }
}
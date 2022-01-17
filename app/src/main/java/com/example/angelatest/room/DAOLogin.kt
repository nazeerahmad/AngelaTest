package com.example.angelatest.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.angelatest.data.User

@Dao
interface DAOLogin {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(user: User):Long

    @Query("SELECT * FROM login_tab")
    fun getAllUsers():LiveData<List<User>>

    @Query("SELECT * FROM login_tab ORDER BY timestamp DESC  LIMIT 1")
    fun getCurrentUser():LiveData<User>
}
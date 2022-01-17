package com.example.angelatest.ui.login.repo

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import com.example.angelatest.data.User
import com.example.angelatest.room.DAOLogin


class LoginRepo(private val dao:DAOLogin) {
    val allUser:LiveData<List<User>> = dao.getAllUsers()

    val lastUser:LiveData<User> = dao.getCurrentUser()

    @WorkerThread
    suspend fun insert(user: User) :Long{
       return dao.insertUser(user)

    }

}
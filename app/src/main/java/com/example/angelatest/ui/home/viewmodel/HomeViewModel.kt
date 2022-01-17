package com.example.angelatest.ui.home.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.angelatest.application.Application
import com.example.angelatest.base.BaseViewModel
import com.example.angelatest.data.User

import com.example.angelatest.data.responsData.LocalResponse
import kotlinx.coroutines.launch

class HomeViewModel():BaseViewModel<Any>() {

    private val repo = Application.getInstance().repo
    val users:LiveData<List<User>> =   repo.allUser
    val currentUser:LiveData<User> = repo.lastUser

    val dataSet :LiveData<LocalResponse> =repo.getData()

    fun insert(user: User)= viewModelScope.launch {
      val value=  repo.insert(user)
        Log.d("TAG", "insert: $value")
    }




}

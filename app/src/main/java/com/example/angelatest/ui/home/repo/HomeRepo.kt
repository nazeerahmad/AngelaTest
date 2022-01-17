package com.example.angelatest.ui.home.repo


import android.util.Log
import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.angelatest.application.Application
import com.example.angelatest.data.User

import com.example.angelatest.data.responsData.LocalResponse
import com.example.angelatest.room.DAOLogin
import com.example.angelatest.utils.Utils
import com.google.gson.Gson



class HomeRepo(private val dao:DAOLogin) {
    val allUser:LiveData<List<User>> = dao.getAllUsers()

    val lastUser:LiveData<User> = dao.getCurrentUser()
    private var responseMutable: MutableLiveData<LocalResponse>?=null

    @WorkerThread
    suspend fun insert(user: User) :Long{
       return dao.insertUser(user)

    }

    fun getData():LiveData<LocalResponse>{
        responseMutable = MutableLiveData()
        initData()
        return responseMutable!!
    }
   private fun initData() {
      val jsonStr=  Utils.getJsonFromAssets(Application.getInstance(),"jKVv22p8.txt")
        Log.d("TAG", "getData: $jsonStr")
       val gson=Gson()
//       val json=gson.toJson(jsonStr)
//       val userListType = object : TypeToken<ProblemResponse>() {}.type
       val response = gson.fromJson(jsonStr, LocalResponse::class.java)
       responseMutable?.value=response

    }

}
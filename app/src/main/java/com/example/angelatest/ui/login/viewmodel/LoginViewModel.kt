package com.example.angelatest.ui.login.viewmodel

import android.util.Log
import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.angelatest.application.Application
import com.example.angelatest.base.BaseViewModel
import com.example.angelatest.data.User
import com.example.angelatest.ui.login.LoginNavigator
import kotlinx.coroutines.launch

class LoginViewModel():BaseViewModel<LoginNavigator>() {

    private val repo = Application.getInstance().repo
    val users:LiveData<List<User>> =   repo.allUser
    val currentUser:LiveData<User> = repo.lastUser

    fun insert(user: User)= viewModelScope.launch {
      val value=  repo.insert(user)
        Log.d("TAG", "insert: $value")
    }

    fun onLoginClick(){
        getNavigator()?.onLoginClick()
    }

}
//class TransactionViewModelFactory(private val repo:TransactionRepo): ViewModelProvider.Factory{
//    override fun <T : ViewModel> create(modelClass: Class<T>): T {
//        if(modelClass.isAssignableFrom(TransactionViewModel::class.java)){
//            @Suppress("UNCHECKED_CAST")
//            return TransactionViewModel(repo) as T
//        }
//        throw IllegalArgumentException("Unknown ViewModel class")
//    }
//
//}
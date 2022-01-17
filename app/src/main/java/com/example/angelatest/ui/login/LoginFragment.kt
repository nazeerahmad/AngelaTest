package com.example.angelatest.ui.login

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.angelatest.R
import com.example.angelatest.base.BaseFragment
import com.example.angelatest.data.User
import com.example.angelatest.databinding.FragmentLoginBinding
import com.example.angelatest.ui.home.viewmodel.HomeViewModel
import com.example.angelatest.ui.login.viewmodel.LoginViewModel
import java.util.concurrent.TimeUnit

class LoginFragment : BaseFragment<FragmentLoginBinding, LoginViewModel>(),LoginNavigator{
    private lateinit var mContext :Context
    private  var navController: NavController?=null

    override fun getLayoutID(): Int {
        return  R.layout.fragment_login
    }

    override fun getViewModel(): Class<LoginViewModel> {
        return LoginViewModel::class.java
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dataBinding.viewModel=viewModel
        viewModel.setNavigator(this)
        navController=Navigation.findNavController(view)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mContext=context
    }

    override fun onLoginClick() {

        val userName = dataBinding.edUserName.text.toString()
        val email = dataBinding.edEmail.text.toString()
        val password=dataBinding.loginPassword.text.toString()

        if(userName.isEmpty()){
            dataBinding.edUserName.error="Please enter name!"
        }else if(email.isEmpty()){
            dataBinding.edEmail.error="Please enter email!"
        }else if(password.isEmpty()){
            dataBinding.loginPassword.error="Please enter password!"
        }else{
            val user =User(userName,email,password,TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis()).toString())
            viewModel.insert(user)
            navController?.navigate(R.id.action_loginFragment_to_homeFragment)
        }




    }


}
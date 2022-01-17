package com.example.angelatest.ui.home

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.angelatest.R
import com.example.angelatest.base.BaseFragment
import com.example.angelatest.databinding.FragmentHomeBinding
import com.example.angelatest.ui.home.viewmodel.HomeViewModel
import com.example.angelatest.utils.Utils


class HomeFragment : BaseFragment<FragmentHomeBinding,HomeViewModel>(),HomeNavigator {

private lateinit var mContext:Context
    override fun getLayoutID(): Int {
        return R.layout.fragment_home
    }

    override fun getViewModel(): Class<HomeViewModel> {
        return HomeViewModel::class.java
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dataBinding.viewModel=viewModel
        viewModel.setNavigator(this)
        val layoutManager= LinearLayoutManager(mContext,LinearLayoutManager.VERTICAL,false)
        dataBinding.recyclerView.layoutManager=layoutManager
        getUser()
        getMedicationData()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mContext=context
    }

    private fun getUser(){
        showHideProgress(true,mContext)
        viewModel.currentUser.observe(viewLifecycleOwner, Observer {
            showHideProgress(false,mContext)
            it?.let {
                dataBinding.tvGreet.text="${Utils.getTimeFromAndroid()} \n ${it.user_name}"
            }
        })
    }

    private fun getMedicationData(){
        viewModel.dataSet.observe(viewLifecycleOwner, Observer {
            it?.let {
                Log.d("TAG", "getMedicationData: ${it.problems[0].Diabetes[0].medications[0].medicationsClasses[0].className.size}")
                dataBinding.recyclerView.adapter=MedicationAdapter(mContext,it.problems[0].Diabetes[0].medications[0].medicationsClasses[0].className[0],this)
            }
        })
    }

    override fun onItemClick(name: String, dose: String, strength: String) {
        val bundle = Bundle()
        bundle.putString("name", name)
        bundle.putString("dose", dose)
        bundle.putString("strength", strength)
        findNavController().navigate(R.id.action_homeFragment_to_detailsFragment,bundle)
    }


}
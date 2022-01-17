package com.example.angelatest.ui.details

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.angelatest.R
import com.example.angelatest.databinding.FragmentDetailsBinding


class DetailsFragment : Fragment() {

    private lateinit var dataBinding:FragmentDetailsBinding
    private lateinit var mContext:Context


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       dataBinding = FragmentDetailsBinding.inflate(LayoutInflater.from(mContext))
        return dataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val name =arguments?.getString("name")
        val dose=arguments?.getString("dose")
        val strength=arguments?.getString("strength")

        dataBinding.tvName.text=name
        dataBinding.tvDose.text=dose
        dataBinding.tvStrength.text=strength
    }
    override fun onAttach(context: Context) {
        super.onAttach(context)
        mContext=context
    }

}
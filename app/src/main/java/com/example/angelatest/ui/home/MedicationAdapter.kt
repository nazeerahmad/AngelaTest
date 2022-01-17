package com.example.angelatest.ui.home

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

import com.example.angelatest.data.responsData.ClassName
import com.example.angelatest.databinding.MedicationRowBinding

class MedicationAdapter(val mContext: Context,val dataSet:ClassName,val navigator: HomeNavigator):
    RecyclerView.Adapter<MedicationAdapter.MediViewHolder>() {
    class MediViewHolder(val dataBinding:MedicationRowBinding):RecyclerView.ViewHolder(dataBinding.root) {

    }

    override fun getItemCount(): Int {
        if(dataSet==null){
            return 0
        }
        return dataSet.associatedDrug.size+dataSet.associatedDrug2.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MediViewHolder {
        val binding=MedicationRowBinding.inflate(LayoutInflater.from(mContext))
       return MediViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MediViewHolder, position: Int) {
                if(position==0){
                    holder.dataBinding.tvName.text="Name: "+dataSet.associatedDrug[0].name//.medicationsClasses[0].className[0]
                    holder.dataBinding.tvDose.text="Dose: "+dataSet.associatedDrug[0].dose
                    holder.dataBinding.tvStrength.text="Strength: "+dataSet.associatedDrug[0].strength
                    holder.dataBinding.root.setOnClickListener {
                        navigator.onItemClick(dataSet.associatedDrug[0].name,dataSet.associatedDrug[0].dose,dataSet.associatedDrug[0].strength)
                    }
        }else if(position==1){
                    holder.dataBinding.tvName.text="Name: "+dataSet.associatedDrug2[0].name
                    holder.dataBinding.tvDose.text="Dose: "+dataSet.associatedDrug2[0].dose
                    holder.dataBinding.tvStrength.text="Strength: "+dataSet.associatedDrug2[0].strength
                    holder.dataBinding.root.setOnClickListener {
                        navigator.onItemClick(dataSet.associatedDrug2[0].name,dataSet.associatedDrug2[0].dose,dataSet.associatedDrug2[0].strength)
                    }
        }
    }
}
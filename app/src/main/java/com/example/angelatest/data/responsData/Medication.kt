package com.example.angelatest.data.responsData

data class Medication(
    val medicationsClasses: List<MedicationsClasse>
){
    data class MedicationsClasse(
        val className: List<ClassName>,
        val className2: List<ClassName2>
    )
}
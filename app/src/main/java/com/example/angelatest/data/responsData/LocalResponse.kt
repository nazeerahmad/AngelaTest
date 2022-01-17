package com.example.angelatest.data.responsData

data class LocalResponse(
    val problems: List<Problem>
){
    data class Problem(
        val Asthma: List<Asthma>,
        val Diabetes: List<Diabete>
    ){
        data class Diabete(
            val labs: List<Lab>,
            val medications: List<Medication>
        )
    }

}
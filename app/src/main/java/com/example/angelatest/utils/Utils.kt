package com.example.angelatest.utils

import android.content.Context
import android.widget.Toast
import java.io.IOException
import java.io.InputStream
import java.nio.charset.Charset
import java.util.*


object Utils {

     fun getTimeFromAndroid() :String{
       var greet =""
         val c = Calendar.getInstance()
         val timeOfDay = c[Calendar.HOUR_OF_DAY]
//        val dt = Date()
//        val hours: Int = dt.getHours()
//        val min: Int = dt.getMinutes()
         when (timeOfDay) {
             in 0..12 -> {
                 greet = "Good Morning"
             }
             in 12..16 -> {
                 greet =  "Good Afternoon"
             }
             in 16..21 -> {
                 greet =  "Good Evening"
             }
             in 21..24 -> {
                 greet =  "Good Night"
             }
         }
         return  greet
    }

    fun getJsonFromAssets(context: Context, fileName: String?): String? {
        var jsonString=""
        jsonString = try {
            val iStream :InputStream = context.assets.open(fileName!!)
            val size: Int = iStream.available()
            val buffer = ByteArray(size)
            iStream.read(buffer)
            iStream.close()
            String(buffer, Charsets.UTF_8)
        } catch (e: IOException) {
            e.printStackTrace()
            return null
        }
        return jsonString
    }
}
package com.ismailaksu.storingdata

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var sharedPreferences : SharedPreferences
    var ageFromPreferences : Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //SharedPreferences Initialize
        sharedPreferences = this.getSharedPreferences("com.ismailaksu.storingdata", Context.MODE_PRIVATE)

        ageFromPreferences = sharedPreferences.getInt("age",0)
        if(ageFromPreferences == 0){
            textView.text = "Your age: "
        }else {
            textView.text = "Your age: $ageFromPreferences"
        }
    }

    fun save(view : View){
        val myAge = editTextTextPersonName.text.toString().toIntOrNull()
        if (myAge  != null) {
            textView.text = "Your age: ${myAge}"
            sharedPreferences.edit().putInt("age",myAge).apply()
        }
    }

    fun delete(view : View){
        ageFromPreferences = sharedPreferences.getInt("age",-1)

        if(ageFromPreferences != -1) {
            sharedPreferences.edit().remove("age").apply()
            textView.text = "Your age: "
        }
    }
}
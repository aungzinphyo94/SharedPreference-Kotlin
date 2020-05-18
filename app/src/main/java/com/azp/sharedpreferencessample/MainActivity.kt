package com.azp.sharedpreferencessample

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val sharedPrefFile = "TEST_SHARED_PREFERENCE"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sharedPreferences: SharedPreferences = this.getSharedPreferences(sharedPrefFile,
            Context.MODE_PRIVATE)

        btnSave.setOnClickListener {

            val name = et_name.text.toString()
            val age = et_age.text.toString().toInt()

            val editor:SharedPreferences.Editor =  sharedPreferences.edit()

            editor.putString("pref_name", name)
            editor.putInt("pref_age", age)

            editor.apply()
            editor.commit()
        }

        btnView.setOnClickListener {
            val nameValue = sharedPreferences.getString("pref_name","default")
            val ageValue = sharedPreferences.getInt("pref_age", 0)

            txtName.text = nameValue.toString()
            txtAge.text = ageValue.toString()
        }

        btnClear.setOnClickListener {
            val editor = sharedPreferences.edit()
            editor.clear()
            editor.apply()
        }
    }
}

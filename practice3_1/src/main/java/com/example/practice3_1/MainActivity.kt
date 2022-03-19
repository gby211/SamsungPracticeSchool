package com.example.practice3_1

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        button3.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
            Log.d("ggs",editTextTextPersonName.toString())
            intent.putExtra(MainActivity2.FIRST_VALUE,editTextTextPersonName.text.toString().toInt())
            intent.putExtra(MainActivity2.SECOND_VALUE,editTextTextPersonName2.text.toString().toInt())
            startActivity(intent)
        }
    }
}
package com.example.practice2_7

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initView()
    }

    private fun initView() {
        toggleButton2.setOnCheckedChangeListener{ buttonView, isChecked->
            if (!isChecked){
                ggs.setBackgroundColor(Color.BLACK)
            }else{
                ggs.setBackgroundColor(Color.WHITE)
            }

        }
    }
}
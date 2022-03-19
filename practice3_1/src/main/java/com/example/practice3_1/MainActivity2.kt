package com.example.practice3_1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main2.*

class MainActivity2 : AppCompatActivity() {

    companion object {
        const val FIRST_VALUE = "firstValue"
        const val SECOND_VALUE = "secondValue"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        var firstValue = intent.getIntExtra(FIRST_VALUE, 0)
        var secondValue = intent.getIntExtra(SECOND_VALUE, 0)

        textView4.text = "ваше чило больше ${firstValue+(secondValue - firstValue)/2}?"

        button.setOnClickListener {
            secondValue -= (secondValue - firstValue)/2
            textView4.text = "ваше чило больше ${firstValue+(secondValue - firstValue)/2}?"
        }
        button2.setOnClickListener {
            firstValue += (secondValue - firstValue)/2
            textView4.text = "ваше чило больше ${firstValue+(secondValue - firstValue)/2}?"
        }


    }
}
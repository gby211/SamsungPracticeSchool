package com.example.practice3_1

import android.os.Bundle
import android.view.View
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

        textView4.text = "ваше чило больше ${averageNumber(firstValue, secondValue)}?"

        button.setOnClickListener {
            secondValue -= (secondValue - firstValue) / 2
            if (isYouNumber(firstValue, secondValue)) {
                textView4.text = "ВАШЕ ЧИСЛО - ${averageNumber(firstValue, secondValue) - 1}!"
                allInvisible()
            } else
                textView4.text = "ваше чило больше ${averageNumber(firstValue, secondValue)}?"

        }
        button2.setOnClickListener {
            firstValue += (secondValue - firstValue) / 2
            if (isYouNumber(firstValue, secondValue)) {
                textView4.text = "ВАШЕ ЧИСЛО - ${averageNumber(firstValue, secondValue)}!"
                allInvisible()
            } else
                textView4.text = "ваше чило больше ${averageNumber(firstValue, secondValue)}?"

        }

        button4.setOnClickListener {
            textView4.text = "ВАШЕ ЧИСЛО ${averageNumber(firstValue, secondValue)}!"
            allInvisible()
        }
    }

    private fun averageNumber(firstValue: Int, secondValue: Int): Int {
        val rangeNumber = secondValue - firstValue
        return secondValue - rangeNumber / 2
    }

    private fun isYouNumber(firstValue: Int, secondValue: Int): Boolean {
        return secondValue - firstValue <= 1
    }

    private fun allInvisible() {
        button.visibility = View.INVISIBLE
        button2.visibility = View.INVISIBLE
        button4.visibility = View.INVISIBLE
        textView4.textSize = 22F
    }
}
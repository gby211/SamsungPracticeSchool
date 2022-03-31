package com.example.practice3_7

import android.content.Context
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class MainActivity : AppCompatActivity(){

    lateinit var textView: TextView

    fun Date.isSaturday(): Boolean = day == 6
    fun Context.toast(message: CharSequence, duration: Int = Toast.LENGTH_SHORT) {
        Toast.makeText(this, message, duration).show()
    }

    fun Int.isGreater(value: Int): Boolean {
        return this > value
    }

    var StringBuilder.lastChar: Char
        get() = get(length - 1)
        set(value: Char) {
            this.setCharAt(length - 1, value)
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

}
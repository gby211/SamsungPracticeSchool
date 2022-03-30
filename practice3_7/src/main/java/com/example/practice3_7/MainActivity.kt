package com.example.practice3_7

import android.content.DialogInterface
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(), DialogInterface.OnClickListener {

    lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        TestCheckboxDialog().show(supportFragmentManager, "YesNoCancelDialog")

    }

    override fun onClick(dialog: DialogInterface?, which: Int) {
        when (which) {
            DialogInterface.BUTTON_POSITIVE -> textView.text = "Вы согласились!";
            DialogInterface.BUTTON_NEGATIVE -> textView.text = "Вы отказались!";
            DialogInterface.BUTTON_NEUTRAL -> textView.text = "Выбор не сделан";
        }
    }
}
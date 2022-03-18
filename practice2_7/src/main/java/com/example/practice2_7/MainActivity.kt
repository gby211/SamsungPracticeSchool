package com.example.practice2_7

import android.os.Bundle
import android.widget.RadioButton
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        initView()
        observeViewModel()
    }

    private fun observeViewModel() {
        viewModel.str.observe(this){
            textView.text = it
        }
    }

    private fun initView() {

        button.setOnClickListener {
            var msg: String = ""
            msg += "EditText :${editText?.text}\n" +
                    "CheckBox: ${ if (checkBox.isChecked) "ON" else "OFF" }\n" +
                    "ToggleButton: ${ if (toggleButton.isChecked) "ON" else "OFF"}\n" +
                    "RadioGroup: ${(findViewById<RadioButton>(rg.checkedRadioButtonId))?.text ?: ""}"
            viewModel.setStr(msg)
        }
    }
}
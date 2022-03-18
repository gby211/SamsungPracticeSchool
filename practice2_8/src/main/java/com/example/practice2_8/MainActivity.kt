package com.example.practice2_8

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        observeViewModel()
        initView()
    }

    private fun observeViewModel() {
        viewModel.str.observe(this) {
            solution.text = it
        }
    }

    private fun initView() {
        spinner.adapter = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_item,
            resources.getStringArray(R.array.spinner_values)
        )
        getSolution.setOnClickListener {
            if (sideA.text.toString() == "" ||sideB.text.toString() == ""|| sideC.text.toString() == ""  ){
                Toast.makeText(this,"Пустые поля",Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }
            val a: Int = sideA.text.toString().toInt()
            val b: Int = sideB.text.toString().toInt()
            val c: Int = sideC.text.toString().toInt()
            when (spinner.selectedItemPosition) {
                0 -> viewModel.setStr(((a + b + c) * 4).toString())
                1 -> viewModel.setStr(((a * b + b * c + a * c) * 2).toString())
                2 -> viewModel.setStr(((a * b * c)).toString())
            }
        }
    }
}
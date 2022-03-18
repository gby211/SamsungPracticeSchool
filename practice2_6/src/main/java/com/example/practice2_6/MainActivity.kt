package com.example.practice2_6

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var viewModel: RandomViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val provider = ViewModelProvider(this)
        viewModel = provider.get(RandomViewModel::class.java)

        initView()
    }

    fun initView(){
        getRnd.setOnClickListener{
            rndNum.setText( (0..50).random().toString())
            viewModel.onClickBtn(rndNum?.text.toString().toInt())
        }
    }

    private fun observeViewModel() {
        viewModel.currentRandomNumber.observe(this, Observer {
            rndNum.setText(it.toString())
        })
    }
}
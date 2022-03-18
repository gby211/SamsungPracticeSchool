package com.example.samsungpracticeschool

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {


    val TAG = "ggs"
    lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val provider = ViewModelProvider(this)
        viewModel = provider.get(MainViewModel::class.java)

        observeViewModel()

        initView()
    }

    private fun observeViewModel() {
        viewModel.counter.observe(this, Observer {
            // СУПЕРВАЖНО, для этого надо подключить  id 'kotlin-android-extensions' в plugins в градле, имплементнуть import kotlinx.android.synthetic.main.activity_main.*
            text_counter.text = it.toString()
            Log.d(TAG, "observeViewModel: ${it.toString()}")
        })
    }

    fun initView(){
        button.setOnClickListener{
            viewModel.onIncrementClicked()
        }
    }
}
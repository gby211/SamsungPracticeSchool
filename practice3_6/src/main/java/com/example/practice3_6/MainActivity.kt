package com.example.practice3_6

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.practice3_6.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(){



    private lateinit var binding : ActivityMainBinding
    private var viewModel = MyViewModel.getMyViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

//        val provider = ViewModelProvider(this)
//        viewModel = provider.get(MyViewModel::class.java)


    }
}
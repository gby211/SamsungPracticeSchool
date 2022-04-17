package com.example.practice3_5

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.practice3_5.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private var tmp = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        initBtn()

    }

    private fun initBtn(){
        binding.button.setOnClickListener{
            val blankFragment1 = BlankFragment1()
            val blankFragment2 = BlankFragment2()
            val manager = supportFragmentManager
            val translation =  manager.beginTransaction()
            val translation2 =  manager.beginTransaction()
            if (tmp == 0){
                translation.replace(R.id.fr1, blankFragment2)
                translation.commit()
                translation2.replace(R.id.fr2, blankFragment1)
                translation2.commit()
                tmp++
            }else{
                translation.replace(R.id.fr1, blankFragment1)
                translation.commit()
                translation2.replace(R.id.fr2, blankFragment2)
                translation2.commit()
                tmp = 0
            }

        }
    }
}
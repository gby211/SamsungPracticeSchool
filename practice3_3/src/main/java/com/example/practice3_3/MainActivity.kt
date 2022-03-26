package com.example.practice3_3

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.practice3_3.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = CustomAdapter(fillList())

        pressedButtonName()
        pressedButtonPhone()
        pressedButtonSex()
    }

    private fun fillList(): List<Person> {
        val data = mutableListOf<Person>()
         data.apply{
             add(Person("m","Pasha","4361"))
             add(Person("m","Sasha","1235"))
             add(Person("m","Zhenia","125"))
             add(Person("m","Misha","39573"))
             add(Person("m","Nikita","1683"))
             add(Person("m","Vadim","147"))
             add(Person("f","Ulia","811"))
             add(Person("f","Sasha","1244"))
             add(Person("f","Masha","8356"))
             add(Person("f","Zina","852"))
             add(Person("f","Margo","26"))
             add(Person("m","Pasha","3236"))
             add(Person("f","Masha","346"))
             add(Person("m","Fedia","421"))
             add(Person("f","Igrid","1123"))
         }
        Log.d("ggs",data.toString())
        return data
    }

    private fun pressedButtonName(){
        binding.buttonName.setOnClickListener {
            sortedBy(fillList(),1)
        }
    }

    private fun pressedButtonPhone(){
        binding.buttonPhone.setOnClickListener {
            sortedBy(fillList(),2)
        }
    }

    private fun pressedButtonSex(){
        binding.buttonSex.setOnClickListener {
            sortedBy(fillList(),3)
        }
    }

    private fun sortedBy(arList: List<Person>, sortBy: Int){
        when (sortBy) {
            1 -> {
                recyclerView.adapter = CustomAdapter(arList.sortedBy { it.name })
            }
            2 -> {
                recyclerView.adapter = CustomAdapter(arList.sortedBy { it.phoneNumber })
            }
            else -> {
                recyclerView.adapter = CustomAdapter(arList.sortedBy { it.sex })
            }
        }
    }
}
package com.example.practice2_8

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel:ViewModel() {
    var str = MutableLiveData<String>()

    fun setStr(str: String){
        this.str.value = str
    }
}
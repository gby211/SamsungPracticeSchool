package com.example.practice2_7

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {
    var str = MutableLiveData<String>()

    fun setStr(value:String){
        str.value = value
    }
}
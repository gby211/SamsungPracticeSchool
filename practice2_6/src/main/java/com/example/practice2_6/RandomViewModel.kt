package com.example.practice2_6;

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

public class RandomViewModel: ViewModel() {

    val currentRandomNumber:MutableLiveData<Int> by lazy {
        MutableLiveData<Int>()
    }

    fun onClickBtn(value: Int){
        currentRandomNumber.value = value
    }
}

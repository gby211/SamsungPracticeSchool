package com.example.practice2_6;

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class RandomViewModel : ViewModel() {


    val currentRandomNumber: MutableLiveData<Int> by lazy {
        MutableLiveData<Int>()
    }

    fun onClickBtn(value: Int) {
        currentRandomNumber.value = value
    }

    companion object {
        @Volatile
        private var INSTANCE: RandomViewModel? = null

        fun getRandomViewModel(): RandomViewModel {
            return INSTANCE ?: synchronized(this){
                val instance = RandomViewModel()
                INSTANCE = instance
                instance
            }
        }
    }

}

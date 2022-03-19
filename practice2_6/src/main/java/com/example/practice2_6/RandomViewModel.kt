package com.example.practice2_6;

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel




class RandomViewModel: ViewModel() {


    val currentRandomNumber:MutableLiveData<Int> by lazy {
        MutableLiveData<Int>()
    }

    fun onClickBtn(value: Int){
        currentRandomNumber.value = value
    }


    class Singletonclass private constructor() {
        private var state:String = "good"
        fun setState(string:String){
            state = string;
        }
        fun getState():String{
            return state
        }
        init {
        }
        companion object : SingletonHolder<Singletonclass>(::Singletonclass)
    }

    open class SingletonHolder<out T: Any>(constructor: () -> T) {
        private var constructor: (() -> T)? = constructor
        private var instance: T? = null
        fun getInstance(): T {
            if (instance != null) {
                return instance!!
            }else {
                instance = constructor!!()
                constructor = null
                return instance!!
            }
        }
    }
}

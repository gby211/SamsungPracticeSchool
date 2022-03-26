package com.example.practice3_5

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment


class BlankFragment1 : Fragment() {

    companion object {

        fun newInstance(): BlankFragment1 {
            return BlankFragment1()
        }
    }

    //3
    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_blank1, container, false)
    }

}
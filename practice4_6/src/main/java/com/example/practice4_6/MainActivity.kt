package com.example.practice4_6

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.icu.text.SimpleDateFormat
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class MainActivity : AppCompatActivity() {
//    val intentFilterTick = IntentFilter("android.intent.action.TIME_TICK")
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//
//        val receiver = MyReceiver()
//        setContentView(R.layout.activity_main)
//        registerReceiver(receiver, intentFilterTick)
//    }

    var time = 0
    var text : TextView? = null

    private val tickReceiver by lazy { makeBroadcastReceiver() }

    companion object {
        private fun getCurrentTimeStamp(): String {
            val simpleDateFormat = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.US)
            } else {
                TODO("VERSION.SDK_INT < N")
            }
            val now = Date()
            return simpleDateFormat.format(now)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        text = findViewById(R.id.textView)
    }

    override fun onResume() {
        super.onResume()
//        dateTimeTextView.text = getCurrentTimeStamp()
        text?.text = "0"
        time = 0
        registerReceiver(tickReceiver, IntentFilter(Intent.ACTION_TIME_TICK))
        registerReceiver(tickReceiver, IntentFilter(Intent.ACTION_BATTERY_LOW))
    }

    override fun onPause() {
        super.onPause()
        try {
            unregisterReceiver(tickReceiver)
        } catch (e: IllegalArgumentException) {
            Log.e("Broadcast", "Time tick Receiver not registered", e)
        }
    }


    private fun makeBroadcastReceiver(): BroadcastReceiver {
        return object : BroadcastReceiver() {
            override fun onReceive(context: Context, intent: Intent?) {
                if (intent?.action == Intent.ACTION_TIME_TICK) {
//                    dateTimeTextView.text = getCurrentTimeStamp()
                    time++
                    text?.text = "время созерцания: $time мин."
                }
                if (intent?.action == Intent.ACTION_BATTERY_LOW){
                    text?.text = "накормите Ждуна, силы на исходе!"
                }
            }
        }
    }

    fun click1(view: View) {
        unregisterReceiver(tickReceiver)
        Toast.makeText(this, getString(R.string.toast_text), Toast.LENGTH_SHORT).show()
    }
}
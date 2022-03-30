package com.example.practice3_7

import android.app.Dialog
import android.app.TimePickerDialog
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.DialogFragment
import java.util.*

class TestTimePickerDialog(private val params: Array<Boolean>): DialogFragment() {
    val c = Calendar.getInstance();
    val curHour = c.get(Calendar.HOUR_OF_DAY);
    val curMinute = c.get(Calendar.MINUTE);
    val a:Boolean = params[0]
    val b:Boolean = params[1]
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        Log.d("ggs", a.toString() + b)
        return TimePickerDialog(activity, {
                _, hour, minute ->
            BlankFragment().setState(
                hour,
                minute,
                a,
                b,
            )
        }, curHour, curMinute, false)
    }
}
package com.example.practice3_7

import android.app.Dialog
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment

class TestCheckboxDialog(val id1: Int) : DialogFragment() {
    val langs = arrayOf("Луна и звёзды ночью", "Солнце днём")
    val checked = booleanArrayOf(true, true)
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let { it ->
            AlertDialog.Builder(it)
                .setMultiChoiceItems(langs, checked) { dialog, which, isChecked ->
                    checked[which] = isChecked
                }
                .setPositiveButton(
                    "Ok"
                ) { dialog, which ->
                    TestTimePickerDialog(checked.toTypedArray(),id1).show(
                        requireActivity().supportFragmentManager,
                        "YesNoCancelDialog1"
                    )
                    Log.d("ggs",checked.toTypedArray().contentToString())
                }.create()
        } ?: throw IllegalStateException("Activity cannot be null")
    }
}
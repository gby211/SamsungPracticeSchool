package com.example.practice3_2

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val regexPhone = Regex("""([0-9]{8})""")
    private val regexWeb = Regex("""^http.*""")
    private val regexGeo = Regex("""(\d)+,(\d)+""")
    private val regexGeo2 = Regex("""(\w)+""")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        button.setOnClickListener {
            val textt = editTextTextPersonName2?.text.toString()
            val bol: Boolean = isRegG(textt)
            val tmp: String = if (isRegG(textt)) {
                "geo:${textt}"
            } else {
                "geo:0,0?q=${textt}&z=8"
            }

            when (radioGroup2!!.checkedRadioButtonId) {
                radioButton.id -> startActivity(
                    Intent(
                        Intent.ACTION_VIEW, Uri.parse(textt)
                    )
                )
                radioButton2.id -> startActivity(
                    Intent(
                        Intent.ACTION_VIEW, Uri.parse(tmp)
                    )
                )
                radioButton3.id -> startActivity(
                    Intent(
                        Intent.ACTION_VIEW, Uri.parse(
                            "tel:${textt}"
                        )
                    )
                )
            }
            if (radioGroup2!!.checkedRadioButtonId != null) {
                val stringText = editTextTextPersonName2?.text.toString()
                var uri: String? = null
                when {
                    stringText.matches(regexPhone) -> uri = "tel:${stringText}"
                    stringText.matches(regexWeb) -> uri = stringText
                    stringText.matches(regexGeo) -> uri = "geo:${stringText}"
                    stringText.matches(regexGeo2) -> uri = "geo:0,0?q=${stringText}&z=8"
                }
//                uri = "https://ya.ru"
                //https://ya.ru
                if (uri != null) {
                    startActivity(
                        Intent(
                            Intent.ACTION_VIEW, Uri.parse(
                                uri
                            )
                        )
                    )
                }
            }
        }
    }

    private fun isRegG(matchResult: String?): Boolean {
        val matchResult = matchResult?.let { Regex("""(\d)+,(\d)+""").find(it) }
        return matchResult != null
    }
}
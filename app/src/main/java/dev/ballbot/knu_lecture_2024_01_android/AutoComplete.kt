package dev.ballbot.knu_lecture_2024_01_android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.MultiAutoCompleteTextView
import androidx.activity.ComponentActivity

class AutoComplete : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auto_complete)

        val items = listOf(
            "Ballbot",
            "Eggobt",
            "GLaDOS",
            "Aperture",
            "Cube"
        )
        val autoCom1 = findViewById<AutoCompleteTextView>(R.id.autocomp1)
        val autoCom2 = findViewById<MultiAutoCompleteTextView>(R.id.autocomp2)
        val adap = ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, items)

        autoCom1.setAdapter(adap)
        autoCom2.setTokenizer(MultiAutoCompleteTextView.CommaTokenizer())
        autoCom2.setAdapter(adap)
    }
}
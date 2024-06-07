package dev.ballbot.knu_lecture_2024_01_android

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.ComponentActivity

class EditTextButton : ComponentActivity() {
    lateinit var input1EditText: EditText
    lateinit var input2EditText: EditText
    lateinit var addButton: Button
    lateinit var subButton: Button
    lateinit var resultTextView: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_text_button)

        this.input1EditText = findViewById(R.id.et1)
        this.input2EditText = findViewById(R.id.et2)
        this.addButton = findViewById(R.id.btn1)
        this.subButton = findViewById(R.id.btn2)
        this.resultTextView = findViewById(R.id.res)

        this.addButton.setOnClickListener { println("af") }
    }
}
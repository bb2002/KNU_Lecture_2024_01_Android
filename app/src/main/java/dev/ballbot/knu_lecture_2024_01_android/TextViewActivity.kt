package dev.ballbot.knu_lecture_2024_01_android

import android.graphics.Color
import android.os.Bundle
import android.widget.TextView
import androidx.activity.ComponentActivity

class TextViewActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.textview_activity)

        val tv1 = findViewById<TextView>(R.id.tv1)
        val tv2 = findViewById<TextView>(R.id.tv2)
        val tv3 = findViewById<TextView>(R.id.tv3)

        tv1.setText("Ballbot Networks")
        tv1.setTextColor(Color.RED)
        tv2.setTextSize(30.0F)
        tv2.setText("Welcome to the aperture")
        tv2.setTypeface(android.graphics.Typeface.SERIF, android.graphics.Typeface.BOLD_ITALIC)
        tv3.setText("곤니찌와곤니찌와곤니찌와곤니찌와곤니찌와곤니찌와곤니찌와곤니찌와곤니찌와곤니찌와곤니찌와")
        tv3.setSingleLine()
    }
}

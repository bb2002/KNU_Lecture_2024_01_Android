package dev.ballbot.knu_lecture_2024_01_android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ViewFlipper
import androidx.activity.ComponentActivity

class ViewFlipperTest : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_flipper_test)

        val next = findViewById<Button>(R.id.next)
        val prev = findViewById<Button>(R.id.prev)
        val flip = findViewById<ViewFlipper>(R.id.flip)
        next.setOnClickListener {
            flip.showNext()
        }
        prev.setOnClickListener {
            flip.showPrevious()
        }
    }
}
package dev.ballbot.knu_lecture_2024_01_android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Chronometer
import androidx.activity.ComponentActivity

class ClockActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_clock)

        val timer = findViewById<Chronometer>(R.id.timer)
        timer.start()
    }
}
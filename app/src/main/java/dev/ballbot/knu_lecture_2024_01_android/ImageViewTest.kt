package dev.ballbot.knu_lecture_2024_01_android

import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.activity.ComponentActivity

class ImageViewTest : ComponentActivity() {
    lateinit var checkbox: CheckBox
    lateinit var loveGames: TextView
    lateinit var valGame: RadioButton
    lateinit var overGame: RadioButton
    lateinit var radioGroup: RadioGroup
    lateinit var compButton: Button
    lateinit var imgView: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image_view_test)

        this.checkbox = findViewById(R.id.checkbox)
        this.loveGames = findViewById(R.id.lovegames)
        this.valGame = findViewById(R.id.`val`)
        this.overGame = findViewById(R.id.overwatch)
        this.radioGroup = findViewById(R.id.rdg)
        this.compButton = findViewById(R.id.comp)
        this.imgView = findViewById(R.id.img)

        this.checkbox.setOnCheckedChangeListener {
            btn, b ->
            if (b) {
                this.radioGroup.visibility = android.view.View.VISIBLE
                this.loveGames.visibility = android.view.View.VISIBLE
                this.valGame.visibility = android.view.View.VISIBLE
                this.overGame.visibility = android.view.View.VISIBLE
            } else {
                this.radioGroup.visibility = android.view.View.GONE
                this.loveGames.visibility = android.view.View.GONE
                this.valGame.visibility = android.view.View.GONE
                this.overGame.visibility = android.view.View.GONE
            }
        }

        this.compButton.setOnClickListener {
            when (this.radioGroup.checkedRadioButtonId) {
                R.id.`val` -> this.imgView.setImageResource(R.drawable.`val`)
                R.id.overwatch -> this.imgView.setImageResource(R.drawable.over)
            }
        }
    }
}
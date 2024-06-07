package dev.ballbot.knu_lecture_2024_01_android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.widget.Button
import android.widget.Toast
import java.io.File

class SimpleImageView : AppCompatActivity() {
    lateinit var myPictureView: MyPictureView
    lateinit var prevButton: Button
    lateinit var nextButton: Button
    var current = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_simple_image_view)

        this.myPictureView = findViewById(R.id.myView)
        this.prevButton = findViewById(R.id.btnPrev)
        this.nextButton = findViewById(R.id.btnNext)

        val imageFiles = File(Environment.getExternalStorageDirectory().absolutePath + "/Pictures").listFiles()
        this.myPictureView.imagePath = imageFiles?.get(current).toString()

        this.prevButton.setOnClickListener {
            if (current <= 0) {
                Toast.makeText(applicationContext, "First Image", Toast.LENGTH_SHORT).show()
            } else {
                --current;
                myPictureView.imagePath = imageFiles?.get(current).toString()
                myPictureView.invalidate()
                Toast.makeText(applicationContext, imageFiles?.get(current).toString(), Toast.LENGTH_SHORT).show()
            }
        }

        this.nextButton.setOnClickListener {
            if (imageFiles != null) {
                if (current >= imageFiles.size - 1) {
                    Toast.makeText(applicationContext, "Last Image", Toast.LENGTH_SHORT).show()
                } else {
                    ++current;
                    myPictureView.imagePath = imageFiles?.get(current).toString()
                    myPictureView.invalidate()
                    Toast.makeText(applicationContext, imageFiles?.get(current).toString(), Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}



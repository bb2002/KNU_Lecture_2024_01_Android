package dev.ballbot.knu_lecture_2024_01_android

import android.content.Context
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.util.AttributeSet
import android.view.View

public class MyPictureView(context: Context, attrs: AttributeSet?) : View(context, attrs) {
    var imagePath: String? = null

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        try {
            if (imagePath != null) {
                val bitmap = BitmapFactory.decodeFile(imagePath)
                canvas.scale(2f, 2f, 0f, 0f)
                canvas.drawBitmap(bitmap!!, 0f, 0f, null)
                bitmap.recycle()
            }
        } catch(ex: Exception) {}
    }
}
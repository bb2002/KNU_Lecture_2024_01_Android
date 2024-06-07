package dev.ballbot.knu_lecture_2024_01_android

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.graphics.Rect
import android.graphics.RectF
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class CanvasAcitivty : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_canvas_acitivty)
    }
}

private class YourClassName(context: Context) : View(context) {
    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        val paint = Paint()
        paint.isAntiAlias = true
        paint.color = Color.GREEN
        canvas.drawLine(10f, 10f, 300f, 10f, paint)

        paint.color = Color.BLUE
        paint.strokeWidth = 5f
        canvas.drawLine(10f, 30f, 300f, 30f, paint)

        paint.color = Color.RED
        paint.strokeWidth = 0f

        paint.style = Paint.Style.FILL
        val rect1 = Rect(10, 50, 10 + 100, 50 + 100)
        canvas.drawRect(rect1, paint)

        paint.style = Paint.Style.STROKE
        val rect2 = Rect(130, 50, 130 + 100, 50 + 100)
        canvas.drawRect(rect2, paint)

        val rect3 = RectF(250f, 50f, 250f + 100f, 50f + 100f)
        canvas.drawRoundRect(rect3, 20f, 20f, paint)

        canvas.drawCircle(60f, 220f, 50f, paint)

        paint.strokeWidth = 5f
        val path1 = Path()
        path1.moveTo(10f, 290f)
        path1.lineTo(10f + 50f, 290f + 50f)
        path1.lineTo(10f + 100f, 290f)
        canvas.drawPath(path1, paint)

        paint.strokeWidth = 0f
        paint.textSize = 30f
        canvas.drawText("BALLBOT", 10f, 390f, paint)

        /*
            퀴즈

            paint.strokeWidth = 30f
            canvas.drawLine(30f, 30f, 300f, 30f, paint)
            paint.strokeCap = Paint.Cap.ROUND //둥근 모양으로 마무리
            canvas.drawLine(30f, 80f, 300f, 80f, paint)
            val rectF = RectF()
            rectF.set(60f, 120f, (60 + 200).toFloat(), (100 + 100).toFloat())
            canvas.drawOval(rectF, paint) // 사각형 안에 딱 맞는 원을 paint로 그림
            rectF.set(60f, 170f, (60 + 100).toFloat(), (170 + 100).toFloat())
            canvas.drawArc(rectF, 40f, 110f, true, paint)
            //호를 그리는 함수
            paint.color = Color.BLUE
            rectF.set(60f, 280f, (60 + 100).toFloat(), (280 + 100).toFloat())
            canvas.drawRect(rectF, paint)
            paint.color = Color.argb(0x88, 0xff, 0x00, 0x00) // 투명도     설정
            rectF.set(90f, 310f, (90 + 100).toFloat(), (310 + 100).toFloat())
            canvas.drawRect(rectF, paint)
         */
    }
}
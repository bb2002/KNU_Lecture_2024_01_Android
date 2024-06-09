package dev.ballbot.knu_lecture_2024_01_android

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.DatePicker
import android.widget.EditText
import android.widget.Toast
import androidx.activity.ComponentActivity
import java.io.FileInputStream
import java.io.IOException
import java.util.Calendar

class DiaryApp : ComponentActivity() {
    var fileName = ""
    lateinit var btn: Button
    lateinit var edt: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_diary_app)

        val cal = Calendar.getInstance()
        val year = cal.get(Calendar.YEAR)
        val month = cal.get(Calendar.MONTH)
        val day = cal.get(Calendar.DAY_OF_MONTH)

        val datePicker = findViewById<DatePicker>(R.id.picker)
        this.btn = findViewById(R.id.write)
        this.edt = findViewById(R.id.editor)
        datePicker.init(year, month, day) {
            view, year, monthOfYear, dayOfMonth ->
            fileName = (Integer.toString(year) + "_" + Integer.toString(monthOfYear) + "_" + Integer.toString(dayOfMonth + 1) + ".txt")
            val str = readDir(fileName)
            edt.setText(str)
        }

        this.btn.setOnClickListener {
            val fs = openFileOutput(fileName, Context.MODE_PRIVATE)
            val str = edt.text.toString()
            fs.write(str.toByteArray())
            fs.close()
            Toast.makeText(applicationContext, "OK", Toast.LENGTH_SHORT).show()
        }

        val btn22 = findViewById<Button>(R.id.btn22)
        btn22.setOnClickListener {
            val inputStream = resources.openRawResource(R.raw.test)
            val arr = ByteArray(512)
            inputStream.read(arr)
            inputStream.close()
            Toast.makeText(applicationContext, arr.toString(Charsets.UTF_8).trim(), Toast.LENGTH_SHORT).show()
        }
    }

    fun readDir(fName: String): String {
        var dirStr: String
        var inFs: FileInputStream

        try {
            inFs = openFileInput(fName)
            var arr = ByteArray(500)
            inFs.read(arr)
            inFs.close()
            dirStr = arr.toString(Charsets.UTF_8).trim()
            this.btn.setText("수정")
            return dirStr
        } catch(e: IOException) {
            this.edt.hint = "일기가 없다"
            this.btn.setText("저장")
        }

        return ""
    }
}
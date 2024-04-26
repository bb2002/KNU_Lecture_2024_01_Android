package dev.ballbot.knu_lecture_2024_01_android

import android.app.AlertDialog
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.activity.ComponentActivity

class ADialogTest : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dialog_test)

        val btn = findViewById<Button>(R.id.dgbtn)
        val btn2 = findViewById<Button>(R.id.dgbtn2)
        val btn3 = findViewById<Button>(R.id.dgbtn3)

        btn.setOnClickListener {
            val dlg = AlertDialog.Builder(this@ADialogTest)
            dlg.setTitle("Title")
            dlg.setMessage("안녕하십니까")
            dlg.setPositiveButton("그래") {
                dialog, which -> Toast.makeText(
                this@ADialogTest,
                "인사를 받았다.",
                Toast.LENGTH_SHORT).show()
            }
            dlg.show()
        }

        btn2.setOnClickListener {
            val arr = arrayOf("오버워치", "발로란트", "에이팩스")
            val dlg = AlertDialog.Builder(this@ADialogTest)
            dlg.setTitle("게임 하실?")
            dlg.setIcon(R.mipmap.ic_launcher)
            dlg.setMultiChoiceItems(arr, booleanArrayOf(false,false,false)) {
                    dlg, which, isChecked -> btn2.text = arr[which]
            }
            dlg.setPositiveButton("겜안해", {
                dlg, which -> Toast.makeText(this@ADialogTest, "젠장", Toast.LENGTH_SHORT).show()
            })
            dlg.show()
        }

        btn3.setOnClickListener {
            val dlg = AlertDialog.Builder(this@ADialogTest)
            val view = View.inflate(this@ADialogTest, R.layout.activity_clock, null)
            dlg.setTitle("게임 하실?")
            dlg.setIcon(R.mipmap.ic_launcher)
            dlg.setView(view)
            dlg.setPositiveButton("닫기", null)
            dlg.show()
        }


    }
}
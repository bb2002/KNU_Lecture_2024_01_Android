package dev.ballbot.knu_lecture_2024_01_android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.ComponentActivity
import java.io.File
import java.io.FileInputStream

class ExternalStorage : ComponentActivity() {
    lateinit var readBtn: Button
    lateinit var mkdirBtn: Button
    lateinit var rmdirBtn: Button
    lateinit var lsDir: Button
    lateinit var editText: EditText
    lateinit var lsResultView: TextView
    val path = Environment.getExternalStorageDirectory().absolutePath
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_external_storage)

        this.readBtn = findViewById(R.id.btn_read)
        this.editText = findViewById(R.id.edt_sd)
        this.mkdirBtn = findViewById(R.id.btn_mkdir)
        this.rmdirBtn = findViewById(R.id.btn_rmdir)
        this.lsDir = findViewById(R.id.btn_ls)
        this.lsResultView = findViewById(R.id.ls_result)

        this.readBtn.setOnClickListener {
            var inFs = FileInputStream("/storage/emulated/0/ballbot.txt")
            var txt = ByteArray(inFs.available())
            inFs.read(txt)
            this.editText.setText(txt.toString(Charsets.UTF_8))
            inFs.close()
        }

        this.mkdirBtn.setOnClickListener {
            val dir = File("$path/mydir")
            dir.mkdir()
        }

        this.rmdirBtn.setOnClickListener {
            val dir = File("$path/mydir")
            dir.delete()
        }

        this.lsDir.setOnClickListener {
            val sysDir = Environment.getRootDirectory().absolutePath
            val sysFiles = File(sysDir).listFiles()
            var result: String = ""

            for (i in sysFiles!!) {
                if (i.isDirectory) {
                    result = "<Folder> " + i.toString()
                } else {
                    result = "<File> " + i.toString()
                }
                this.lsResultView.text = this.lsResultView.text.toString() + "\n" + result
            }
        }
    }

    override fun onResume() {
        super.onResume()
        Toast.makeText(applicationContext, path, Toast.LENGTH_SHORT).show()
    }
}
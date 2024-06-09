package dev.ballbot.knu_lecture_2024_01_android

import android.content.ContentValues
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class SQLiteActivity : AppCompatActivity() {
    data class Memo(val no: Long, val content: String, val createdAt: Long) {}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sqlite)

        // MemoDbHelper()...
    }

    inner class MemoDbHelper(context: android.content.Context) : SQLiteOpenHelper(context, "ballbot.db", null, 0) {
        fun insertMemo(memo: Memo) {
            val values = ContentValues()
            values.put("content", memo.content)
            values.put("createdAt", memo.createdAt)

            writableDatabase.insert("memo", null, values)
            writableDatabase.close()
        }

        fun selectMemo(): MutableList<Memo> {
            val list = mutableListOf<Memo>()
            val cursor = readableDatabase.rawQuery("SELECT * FROM memo", null)
            while (cursor.moveToNext()) {
                val noIdx = cursor.getColumnIndex("_id")
                val contentIdx = cursor.getColumnIndex("content")
                val datetimeIdx = cursor.getColumnIndex("createdAt")

                list.add(Memo(
                    cursor.getLong(noIdx),
                    cursor.getString(contentIdx),
                    cursor.getLong(datetimeIdx))
                )
            }
            cursor.close()
            readableDatabase.close()
            return list
        }

        fun update(memo: Memo) {
            val values = ContentValues()
            values.put("content", memo.content)
            values.put("datetime", memo.createdAt)
            writableDatabase.update("memo", values, "no = ${memo.no}", null)
            writableDatabase.close()
        }

        fun delMemo(memo: Memo) {
            writableDatabase.execSQL("DELETE FROM memo WHERE no = ${memo.no}")
            writableDatabase.close()
        }

        override fun onCreate(db: SQLiteDatabase?) {
            db?.execSQL("CREATE TABLE memo ( _id INTEGER PRIMARY KEY, content TEXT, datetime INTEGER )");
        }

        override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        }
    }


}
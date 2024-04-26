package dev.ballbot.knu_lecture_2024_01_android

import android.app.Activity
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import androidx.activity.ComponentActivity

class OptionMenuTest : Activity() {
    lateinit var btn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_option_menu_test)

        this.btn = findViewById<Button>(R.id.btn1)

        registerForContextMenu(this.btn)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        super.onCreateOptionsMenu(menu)
        val inf = menuInflater
        inf.inflate(R.menu.option_menu, menu)
        return true
    }

    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)
        val inf = this.menuInflater
        if (v === this.btn) {
            menu!!.setHeaderTitle("Welcome")
            inf.inflate(R.menu.option_menu, menu)
        }
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        super.onContextItemSelected(item)

        return when (item.itemId) {
            R.id.item_red -> {
                this.btn.setBackgroundColor(Color.RED)
                true
            }
            R.id.sub_rotate -> {
                this.btn.rotation = 45F
                true
            }
            else -> false
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        super.onOptionsItemSelected(item)

        return when (item.itemId) {
            R.id.item_red -> {
                this.btn.setBackgroundColor(Color.RED)
                true
            }
            R.id.sub_rotate -> {
                this.btn.rotation = 45F
                true
            }
            else -> false
        }
    }
}
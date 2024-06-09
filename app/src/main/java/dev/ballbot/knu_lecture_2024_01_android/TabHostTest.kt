package dev.ballbot.knu_lecture_2024_01_android

import android.app.TabActivity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TabHost

class TabHostTest : TabActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tab_host_test)

        val tabHost = this.tabHost

        var specSong = tabHost.newTabSpec("SONG").setIndicator("음악별")
        specSong.setContent(R.id.a)
        tabHost.addTab(specSong)

        var specArt = tabHost.newTabSpec("ART").setIndicator("그림별")
        specArt.setContent(R.id.b)
        tabHost.addTab(specArt)

        var specAlbum = tabHost.newTabSpec("ALBUM").setIndicator("엘범별")
        specAlbum.setContent(R.id.c)
        tabHost.addTab(specAlbum)

        tabHost.currentTab = 0
    }
}
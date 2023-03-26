package com.example.seenablow

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.view.View
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.cardview.widget.CardView
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {
    var card_nov: CardView? = null
    var card_poem: CardView? = null
    var card_news: CardView? = null
    var card_column: CardView? = null
    private var toolbar: Toolbar? = null
    private var drawerLayout: DrawerLayout? = null
    private var navigationView: NavigationView? = null
    var navi_textview: TextView? = null
    var navi_textview2: TextView? = null
    var username: String? = null
    var age: String? = null
    var gender: String? = null
    var classes: String? = null
    //var intent: Intent? = null
    var isclick = false
    var navi_icon: ImageView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //해당 액티비티를 잠금화면에 띄워줌
        setContentView(R.layout.activity_main)
        card_nov = findViewById<CardView>(R.id.card_nov)
        card_poem = findViewById<CardView>(R.id.card_poem)
        card_news = findViewById<CardView>(R.id.card_news)
        card_column = findViewById<CardView>(R.id.card_column)
        drawerLayout = findViewById<DrawerLayout>(R.id.drawer_layout)
        intent = getIntent()
        navigationView = findViewById<View>(R.id.naviView) as NavigationView
        navigationView!!.setNavigationItemSelectedListener { item: MenuItem ->
            onOptionsItemSelected(
                item
            )
        }
        val nav_header_view = navigationView!!.getHeaderView(0)
        navi_textview = nav_header_view.findViewById<View>(R.id.user_name) as TextView
        val nav_header_view2 = navigationView!!.getHeaderView(0)
        navi_textview2 = nav_header_view2.findViewById<View>(R.id.userinfo) as TextView
        val nav_header_view3 = navigationView!!.getHeaderView(0)
        navi_icon = nav_header_view3.findViewById<View>(R.id.navi_icon) as ImageView
        toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        //액션바 객체
        val actionBar = supportActionBar
        actionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setDisplayShowTitleEnabled(false)

        //뒤로가기 버튼 이미지 적용
        actionBar.setHomeAsUpIndicator(R.drawable.ic_menu)
        val sharedPreferences = getSharedPreferences("username", MODE_PRIVATE)
        username = sharedPreferences.getString("username", "")
        age = sharedPreferences.getString("age", "")
        gender = sharedPreferences.getString("gender", "")
        classes = sharedPreferences.getString("class", "")

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        isclick = false
        val id = item.itemId
        if (id == R.id.menu_item1) {
        } else if (id == R.id.menu_item2) {
            Log.d("실행", "ㅇㅇ")
            if (Build.VERSION.SDK_INT >= 28) {
                startForegroundService(intent)
                Log.v("asdf", "startService!")
            }
        }
        when (item.itemId) {
            android.R.id.home -> {
                if (classes == "8") {
                    navi_icon!!.setImageResource(R.drawable.uni_1color)
                } else if (classes == "7") {
                    navi_icon!!.setImageResource(R.drawable.uni_2color)
                } else if (classes == "6") {
                    navi_icon!!.setImageResource(R.drawable.uni_3color)
                } else if (classes == "5") {
                    navi_icon!!.setImageResource(R.drawable.uni_4color)
                } else if (classes == "4") {
                    navi_icon!!.setImageResource(R.drawable.uni_5color)
                } else if (classes == "3") {
                    navi_icon!!.setImageResource(R.drawable.uni_6color)
                } else if (classes == "2") {
                    navi_icon!!.setImageResource(R.drawable.uni_7color)
                } else if (classes == "1") {
                    navi_icon!!.setImageResource(R.drawable.uni_8color)
                }
                navi_textview!!.text = username
                navi_textview2!!.text = "$age 세 $gender"
                drawerLayout!!.openDrawer(GravityCompat.START)
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onBackPressed() {
        val alert_ex = AlertDialog.Builder(this)
        alert_ex.setMessage("정말로 종료하시겠습니까?")
        alert_ex.setNegativeButton("취소") { dialog, which -> }
        alert_ex.setPositiveButton("종료") { dialog, which -> finishAffinity() }
        alert_ex.setTitle("Good Bye!")
        val alert = alert_ex.create()
        alert.show()
    }
}
package munmang.sdk.seenablow

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import munmang.sdk.seenablow.databinding.ActivityMainBinding
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private var toolbar: Toolbar? = null
    private lateinit var drawerLayout: DrawerLayout
    private var navigationView: NavigationView? = null
    var navi_textview: TextView? = null
    var navi_textview2: TextView? = null
    var username: String? = null
    var age: String? = null
    var gender: String? = null
    var classes: String? = null
    //var intent: Intent? = null
    //
    var isclick = false
    var navi_icon: ImageView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //해당 액티비티를 잠금화면에 띄워줌
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        drawerLayout = binding.drawerLayout

//        binding.cardNov!!.setOnClickListener {
//            //MoveIntent()
//        }
//        binding.cardPoem!!.setOnClickListener {
//            //MoveIntent()
//        }
//
//        binding.cardNews!!.setOnClickListener {
//           //MoveIntent()
//        }
//
//        binding.cardColumn!!.setOnClickListener {
//            //MoveIntent()
//        }

        intent = getIntent()

        binding.naviView.setNavigationItemSelectedListener { item: MenuItem ->
            onOptionsItemSelected(
                item
            )
        }

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
                drawerLayout.openDrawer(GravityCompat.START)
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }


    fun MoveIntent(){
        val intent = Intent(this@MainActivity, NovActivity::class.java)
        intent.putExtra("name", "news")
        startActivity(intent)
    }
    override fun onBackPressed() {
        val alert_ex = AlertDialog.Builder(this)
        alert_ex.setMessage("정말로 종료하시겠습니까?")
        alert_ex.setNegativeButton("취소") { _, _ -> }
        alert_ex.setPositiveButton("종료") { _, _ -> finishAffinity() }
        alert_ex.setTitle("Good Bye!")
        val alert = alert_ex.create()
        alert.show()
    }
}
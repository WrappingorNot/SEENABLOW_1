package munmang.sdk.seenablow

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.seenablow.R
import com.example.seenablow.databinding.ActivityQuizBinding
import java.util.*

class QuizActivity : AppCompatActivity() {

    private  var intent: Intent? = null
    var ans1: String? = null
    var ans2:kotlin.String? = null
    var ans3:kotlin.String? = null
    var quiz:kotlin.String? = null
    var tv_quiz: TextView? = null
    var requestQueue: RequestQueue? = null
    var username: String? = null
    var url:kotlin.String? = null
    private lateinit var binding: ActivityQuizBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityQuizBinding.inflate(layoutInflater)
        setContentView(binding.root)

        tv_quiz = findViewById(R.id.tv_quiz)
        intent = getIntent()
        val sharedPreferences = getSharedPreferences("username", MODE_PRIVATE)
        username = sharedPreferences.getString("username", "")
        url = "http://172.30.1.52:3002/solving?username="
        url += username

        ans1 = intent!!.getStringExtra("단어")
        ans2 = intent!!.getStringExtra("틀린답1")
        ans3 = intent!!.getStringExtra("틀린답2")
        quiz = intent!!.getStringExtra("뜻")
        binding.tvQuiz.setText(quiz)
        var array = arrayOf<String?>(ans1, ans2, ans3)
        val answer_array = arrayOf<Button?>(binding.btnAnswer1, binding.btnAnswer2, binding.btnAnswer3)
        Collections.shuffle(Arrays.asList(*answer_array))
        Collections.shuffle(Arrays.asList(*array))
        for (i in answer_array.indices) {
            answer_array[i]!!.text = array[i]
        }
        if (requestQueue == null) {
            requestQueue = Volley.newRequestQueue(applicationContext)
        }
        binding.btnAnswer1.setOnClickListener(View.OnClickListener {
            if (binding.btnAnswer1.getText() == ans1) {
                url += "&solve=Y"
                url += "&word=$ans1"
                Toast.makeText(applicationContext, "정답입니다!", Toast.LENGTH_SHORT).show()
                val request = StringRequest(
                    Request.Method.GET,
                    url,
                    { }) { }
                requestQueue!!.add(request)
                //onBackPressed()
            } else {
                Toast.makeText(applicationContext, "다시 선택해주세요!", Toast.LENGTH_SHORT).show()
            }
        })
        binding.btnAnswer2.setOnClickListener(View.OnClickListener {
            if (binding.btnAnswer2.getText() == ans1) {
                url += "&solve=Y"
                url += "&word=$ans1"
                Toast.makeText(applicationContext, "정답입니다", Toast.LENGTH_SHORT).show()
                val request = StringRequest(
                    Request.Method.GET,
                    url,
                    { }) { }
                requestQueue!!.add(request)
                //onBackPressed()
            } else {
                Toast.makeText(applicationContext, "다시 선택해주세요!", Toast.LENGTH_SHORT).show()
            }
        })
        binding.btnAnswer3.setOnClickListener(View.OnClickListener {
            if (binding.btnAnswer3.getText() == ans1) {
                url += "&solve=Y"
                url += "&word=$ans1"
                Toast.makeText(applicationContext, "정답입니다!", Toast.LENGTH_SHORT).show()
                val request = StringRequest(
                    Request.Method.GET,
                    url,
                    { }) { }
                requestQueue!!.add(request)
                //onBackPressed()
            } else {
                Toast.makeText(applicationContext, "다시 선택해주세요!", Toast.LENGTH_SHORT).show()
            }
        })
    }



}
package munmang.sdk.seenablow

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.RequestQueue
import com.android.volley.toolbox.Volley
import com.example.seenablow.databinding.ActivitySignBinding

class SignActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignBinding

    var requestQueue: RequestQueue? = null

    var gender: String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignBinding.inflate(layoutInflater)
        setContentView(binding.root)



        val pref = getSharedPreferences("isFirst", MODE_PRIVATE)
        val first = pref.getBoolean("isFirst", false)

        val pref_data = getSharedPreferences("username", MODE_PRIVATE)

        val editor = pref.edit()
        val editor_data = pref_data.edit()
        if (first == false) {
            if (requestQueue == null) {
                requestQueue = Volley.newRequestQueue(applicationContext)
            }
            binding.btnSignup.setOnClickListener(View.OnClickListener {
                val username: String = binding.etUsername.text.toString()
                val age: String = binding.etAge.text.toString()
                if (binding.rbMan.isChecked() == true) {
                    gender = binding.rbMan.text.toString()
                } else if (binding.rbWoman.isChecked() == true) {
                    gender = binding.rbWoman.getText().toString()
                } else {
                    Toast.makeText(applicationContext, "성별을 선택하세요", Toast.LENGTH_SHORT).show()
                }

                editor_data.putString("username", username)
                editor_data.putString("age", age)
                editor_data.putString("gender", gender)
                editor_data.apply()
                editor_data.commit()
                editor.putBoolean("isFirst", true)
                editor.apply()
                editor.commit()
                val intent = Intent(this, MainActivity::class.java)
                intent.putExtra("username", username)
                intent.putExtra("age", age)
                intent.putExtra("gender", gender)
                startActivity(intent)
            })
            //앱 최초 실행시 하고 싶은 작업
        } else {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }


    }
}

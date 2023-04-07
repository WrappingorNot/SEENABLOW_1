package com.example.seenablow

import android.os.Bundle
import android.view.View
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import com.example.seenablow.databinding.ActivityLockscreenBinding
import java.util.*

class LockscreenActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLockscreenBinding

    private var random : Int =0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLockscreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        window.addFlags(
            WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED or
                    WindowManager.LayoutParams.FLAG_DISMISS_KEYGUARD or
                    WindowManager.LayoutParams.FLAG_TURN_SCREEN_ON
        )

        val arr = arrayOf("novel", "poem", "news", "column")
        random = Random().nextInt(arr.size - 1)
        var url = "http://172.30.1.52:3002/"
        url += arr[random]
    }


    override fun onResume() {
        super.onResume()

        binding.btnStart.setOnClickListener(View.OnClickListener {

            //어플 태스크 목록에서 완전 삭제 기능
//                moveTaskToBack(true); // 태스크를 백그라운드로 이동
//                finishAndRemoveTask(); // 액티비티 종료 + 태스크 리스트에서 지우기
//                System.exit(0);
            onBackPressed()

        })
    }


}
package com.example.seenablow

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.seenablow.databinding.ActivityLockscreenBinding

class LockscreenActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLockscreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLockscreenBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.root
    }
}
package munmang.sdk.seenablow

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.seenablow.databinding.ActivityNovBinding

class NovActivity : AppCompatActivity() {
    private lateinit var binding: ActivityNovBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNovBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}
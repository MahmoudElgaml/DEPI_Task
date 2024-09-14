package com.example.myapplicationandroid

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.util.Patterns
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.widget.doAfterTextChanged
import com.example.myapplicationandroid.databinding.ActivityMainBinding
import java.util.regex.Pattern

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d("mahmoud","oncreate")
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



    }

    override fun onStart() {
        Log.d("mahmoud","onstart")
        super.onStart()
    }

    override fun onResume() {
        Log.d("mahmoud","onresume")
        super.onResume()
    }

    override fun onPause() {
        Log.d("mahmoud","onPause")
        super.onPause()
    }

    override fun onStop() {
        Log.d("mahmoud","onstop")
        super.onStop()
    }
}

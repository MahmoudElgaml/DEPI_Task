package com.example.myapplication

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import com.example.myapplication.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.Job

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.buffer
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch

import kotlin.math.log

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var viewModel: MyViewModel

    override fun onCreate(savedInstanceState: Bundle?) {


        lifecycleScope.launch {
            flow<Int> {
                for (i in 1..100) {
                    emit(i)
                    delay(1000)
                }
            }.buffer().collect {

                delay(1000)
                Log.i("test", "$it")

            }
        }




        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        viewModel = MyViewModel()
        binding = ActivityMainBinding.inflate(layoutInflater)
        viewModel.score1.observe(this, Observer {
            binding.team1score.text = it.toString()

        })
        viewModel.score2.observe(this, Observer {
            binding.team2score.text = it.toString()

        })

        binding.button1.setOnClickListener {
            viewModel.increamentTeam1()


        }
        binding.button2.setOnClickListener {
            viewModel.increamentTeam2()
        }


        setContentView(binding.root)


    }
}
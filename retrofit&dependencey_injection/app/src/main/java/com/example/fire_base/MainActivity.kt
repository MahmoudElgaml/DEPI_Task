package com.example.fire_base

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fire_base.databinding.ActivityMainBinding
import com.example.myapplication3.TaskAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlin.math.log
@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var viewModel: AlbumViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        viewModel = ViewModelProvider(this).get(AlbumViewModel::class.java)
        setContentView(binding.root)

        viewModel.album.observe(this, Observer {

            binding.recyclerView.adapter= TaskAdapter(viewModel.album.value?.toMutableList()?: mutableListOf())
            binding.recyclerView.layoutManager= LinearLayoutManager(this)

        })

    }
}
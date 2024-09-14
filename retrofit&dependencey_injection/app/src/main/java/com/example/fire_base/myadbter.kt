package com.example.myapplication3

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.fire_base.Albums
import com.example.fire_base.databinding.CardBinding


class TaskAdapter(
    private var albumList: MutableList<Albums>,

    ) :
    RecyclerView.Adapter<TaskAdapter.TaskViewHolder>() {

    // ViewHolder class using ViewBinding
    class TaskViewHolder(val binding: CardBinding) : RecyclerView.ViewHolder(binding.root)

    // Inflate the item layout using ViewBinding and return a ViewHolder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val binding = CardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TaskViewHolder(binding)
    }

    // Bind the data to the views for each item in the list
    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        val currentTask = albumList[position]

        holder.binding.apply {
            userIdText.text = currentTask.userId.toString()
            idText.text = currentTask.id.toString()
            titleText.text = currentTask.title
        }
    }

    // Return the total number of items in the list
    override fun getItemCount(): Int {
        return albumList.size
    }


}

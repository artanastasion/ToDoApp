package com.example.myapplication.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.model.TaskModel
import kotlinx.android.synthetic.main.item_layout.view.*

class TaskAdapter: RecyclerView.Adapter<TaskAdapter.TaskViewHolder>() {

    var listTask = emptyList<TaskModel>()

    class TaskViewHolder(view: View): RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return TaskViewHolder(view)
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        holder.itemView.enabled.text = listTask[position].title
    }

    override fun getItemCount(): Int {
        return listTask.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setListTasks(list: List<TaskModel>){
        listTask = list
        notifyDataSetChanged()
    }

}
package com.example.myapplication.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.model.TaskListModel
import com.example.myapplication.model.TaskModel
import com.example.myapplication.screens.start.StartFragment
import kotlinx.android.synthetic.main.fragment_add_task.view.*
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
        holder.itemView.favorites_cb.isChecked = listTask[position].favorite

    }

    override fun getItemCount(): Int {
        return listTask.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setListTasks(list: List<TaskModel>){
        listTask = list
        notifyDataSetChanged()
    }

    override fun onViewAttachedToWindow(holder: TaskViewHolder) {
        super.onViewAttachedToWindow(holder)
        holder.itemView.setOnClickListener{
            StartFragment.clickedTask(listTask[holder.adapterPosition])
        }
    }

    override fun onViewDetachedFromWindow(holder: TaskViewHolder) {
        holder.itemView.setOnClickListener(null)

    }
}
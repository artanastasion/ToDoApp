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
import kotlinx.android.synthetic.main.fragment_detail.view.*
import kotlinx.android.synthetic.main.item_layout.view.*
import kotlinx.android.synthetic.main.list_title.view.*

class TaskListAdapter: RecyclerView.Adapter<TaskListAdapter.TaskListViewHolder>() {

    var listLists = emptyList<TaskListModel>()

    class TaskListViewHolder(view: View): RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_title, parent, false)
        return TaskListViewHolder(view)
    }

    override fun onBindViewHolder(holder: TaskListViewHolder, position: Int) {
        holder.itemView.title_list.text = listLists[position].title
    }

    override fun getItemCount(): Int {
        return listLists.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setList(list: List<TaskListModel>){
        listLists = list
        notifyDataSetChanged()
    }

    override fun onViewAttachedToWindow(holder: TaskListViewHolder) {
        super.onViewAttachedToWindow(holder)
        holder.itemView.setOnClickListener{
            StartFragment.clickedList(listLists[holder.adapterPosition])
        }
    }

    override fun onViewDetachedFromWindow(holder: TaskListViewHolder) {
        holder.itemView.setOnClickListener(null)

    }

}
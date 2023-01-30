package com.example.myapplication.db.repository

import androidx.lifecycle.LiveData
import com.example.myapplication.model.TaskListModel

interface TaskListRepository {

    val allLists : LiveData<List<TaskListModel>>
    fun getListTitle(int: Int): LiveData<List<TaskListModel>>
    suspend fun insertTaskList(taskListModel: TaskListModel, onSuccess:() -> Unit)
    suspend fun deleteTaskList(taskListModel: TaskListModel, onSuccess:() -> Unit)
    suspend fun updateTaskList(taskListModel: TaskListModel, onSuccess:() -> Unit)
}
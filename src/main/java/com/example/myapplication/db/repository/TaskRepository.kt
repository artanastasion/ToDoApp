package com.example.myapplication.db.repository

import androidx.lifecycle.LiveData
import com.example.myapplication.model.TaskModel

interface TaskRepository {

    val allTasks : LiveData<List<TaskModel>>

    suspend fun insertTask(taskModel: TaskModel, onSuccess:() -> Unit)
    suspend fun deleteTask(taskModel: TaskModel, onSuccess:() -> Unit)
    suspend fun updateTask(taskModel: TaskModel, onSuccess:() -> Unit)
}
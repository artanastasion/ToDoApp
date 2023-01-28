package com.example.myapplication.db.repository

import androidx.lifecycle.LiveData
import com.example.myapplication.db.dao.TaskDao
import com.example.myapplication.model.TaskModel

class TaskRealisation(private val taskDao: TaskDao): TaskRepository {
    override val allTasks: LiveData<List<TaskModel>>
        get() = taskDao.getAllTasks()

    override suspend fun insertTask(taskModel: TaskModel, onSuccess: () -> Unit) {
        taskDao.insert(taskModel)
        onSuccess()
    }

    override suspend fun deleteTask(taskModel: TaskModel, onSuccess: () -> Unit) {
        taskDao.delete(taskModel)
        onSuccess()
    }

    override suspend fun updateTask(taskModel: TaskModel, onSuccess: () -> Unit) {
        taskDao.update(taskModel)
        onSuccess()

    }


}
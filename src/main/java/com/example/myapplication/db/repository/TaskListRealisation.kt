package com.example.myapplication.db.repository

import androidx.lifecycle.LiveData
import com.example.myapplication.db.dao.TaskListDao
import com.example.myapplication.model.TaskListModel

class TaskListRealisation(private val taskListDao: TaskListDao) : TaskListRepository {
    override val allLists: LiveData<List<TaskListModel>>
        get() = taskListDao.getAllLists()

    override fun getListTitle(int: Int): LiveData<List<TaskListModel>> {
        return taskListDao.getListTitle(int)
    }

    override suspend fun insertTaskList(taskListModel: TaskListModel, onSuccess: () -> Unit) {
        taskListDao.insert(taskListModel)
        onSuccess()
    }

    override suspend fun deleteTaskList(taskListModel: TaskListModel, onSuccess: () -> Unit) {
        taskListDao.delete(taskListModel)
        onSuccess()
    }

    override suspend fun updateTaskList(taskListModel: TaskListModel, onSuccess: () -> Unit) {
        taskListDao.update(taskListModel)
        onSuccess()
    }

}
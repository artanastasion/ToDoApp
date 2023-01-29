package com.example.myapplication.screens.start

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.REPOSITORY_LIST
import com.example.myapplication.REPOSITORY_TASK
import com.example.myapplication.db.DataBase
import com.example.myapplication.db.repository.TaskListRealisation
import com.example.myapplication.db.repository.TaskRealisation
import com.example.myapplication.model.TaskListModel
import com.example.myapplication.model.TaskModel

class StartViewModel(application: Application):AndroidViewModel(application) {

    val context = application

    fun initDatabase(){
        val daoTask = DataBase.getInstance(context).getTaskDao()
        val daoTaskList = DataBase.getInstance(context).getTaskListDao()
        REPOSITORY_TASK = TaskRealisation(daoTask)
        REPOSITORY_LIST = TaskListRealisation(daoTaskList)
    }

    fun getAllTasks(): LiveData<List<TaskModel>>{
        return REPOSITORY_TASK.allTasks
    }

    fun getAllLists(): LiveData<List<TaskListModel>>{
        return REPOSITORY_LIST.allLists
    }
}
package com.example.myapplication.screens.list

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.myapplication.REPOSITORY_LIST
import com.example.myapplication.REPOSITORY_TASK
import com.example.myapplication.db.DataBase
import com.example.myapplication.db.repository.TaskRealisation
import com.example.myapplication.model.TaskListModel
import com.example.myapplication.model.TaskModel

class SortListViewModel(application: Application): AndroidViewModel(application) {

    val context = application

    fun initDatabase(){
        val daoTask = DataBase.getInstance(context).getTaskDao()
        REPOSITORY_TASK = TaskRealisation(daoTask)
    }

    fun getSortList(int: Int): LiveData<List<TaskModel>> {
        return REPOSITORY_TASK.sortTask(int)
    }
    fun getAllTasks(): LiveData<List<TaskModel>>{
        return REPOSITORY_TASK.allTasks
    }

    fun getAllLists(): LiveData<List<TaskListModel>>{
        return REPOSITORY_LIST.allLists
    }
}
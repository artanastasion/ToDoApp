package com.example.myapplication.screens.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.REPOSITORY_LIST
import com.example.myapplication.REPOSITORY_TASK
import com.example.myapplication.model.TaskListModel
import com.example.myapplication.model.TaskModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DetailListViewModel:ViewModel() {

    fun delete(taskListModel: TaskListModel, onSuccess:() -> Unit) =
        viewModelScope.launch (Dispatchers.IO){
            REPOSITORY_LIST.deleteTaskList(taskListModel){
                onSuccess()
            }
        }

    fun update(taskListModel: TaskListModel, onSuccess:() -> Unit) =
        viewModelScope.launch (Dispatchers.IO){
            REPOSITORY_LIST.updateTaskList(taskListModel){
                onSuccess()
            }
        }
}
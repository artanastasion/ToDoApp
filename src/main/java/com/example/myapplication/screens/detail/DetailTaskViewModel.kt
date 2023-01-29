package com.example.myapplication.screens.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.REPOSITORY_TASK
import com.example.myapplication.model.TaskModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DetailTaskViewModel:ViewModel() {
    fun delete(taskModel: TaskModel, onSuccess:() -> Unit) =
        viewModelScope.launch (Dispatchers.IO){
            REPOSITORY_TASK.deleteTask(taskModel){
                onSuccess()
            }
        }

    fun update(taskModel: TaskModel, onSuccess:() -> Unit) =
        viewModelScope.launch (Dispatchers.IO){
            REPOSITORY_TASK.updateTask(taskModel){
                onSuccess()
            }
        }

}
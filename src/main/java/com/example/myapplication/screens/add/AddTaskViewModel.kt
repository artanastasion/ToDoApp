package com.example.myapplication.screens.add

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.REPOSITORY_TASK
import com.example.myapplication.model.TaskModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AddTaskViewModel:ViewModel() {

    fun insert(taskModel: TaskModel, onSuccess:() -> Unit) =
        viewModelScope.launch (Dispatchers.IO){
            REPOSITORY_TASK.insertTask(taskModel){
                onSuccess()
            }
        }
}
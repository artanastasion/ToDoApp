package com.example.myapplication.screens.add

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.REPOSITORY_LIST
import com.example.myapplication.REPOSITORY_TASK
import com.example.myapplication.model.TaskListModel
import com.example.myapplication.model.TaskModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AddTaskListViewModel: ViewModel() {
    fun insert(taskListModel: TaskListModel, onSuccess:() -> Unit) =
        viewModelScope.launch (Dispatchers.IO){
            REPOSITORY_LIST.insertTaskList(taskListModel){
                onSuccess()
            }
        }
}
package com.example.myapplication.db.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.myapplication.model.TaskListModel
import com.example.myapplication.model.TaskModel

interface TaskListDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(taskListModel: TaskListModel)

    @Delete
    suspend fun delete(taskListModel: TaskListModel)

    @Update
    suspend fun update(taskListModel: TaskListModel)


    @Query("SELECT * FROM taskList_table")
    fun getAllLists(): LiveData<List<TaskListModel>>
}
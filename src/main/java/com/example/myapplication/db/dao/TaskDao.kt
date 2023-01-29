package com.example.myapplication.db.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.myapplication.model.TaskModel

@Dao
interface TaskDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(taskModel: TaskModel): Long

    @Delete
    suspend fun delete(taskModel: TaskModel)

    @Update
    suspend fun update(taskModel: TaskModel)


    @Query("SELECT * FROM task_table")
    fun getAllTasks(): LiveData<List<TaskModel>>

}
package com.example.myapplication.db.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.myapplication.model.TaskListModel

@Dao
interface TaskListDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(taskListModel: TaskListModel):Long

    @Delete
    suspend fun delete(taskListModel: TaskListModel)

    @Update
    suspend fun update(taskListModel: TaskListModel)


    @Query("SELECT * FROM taskList_table")
    fun getAllLists(): LiveData<List<TaskListModel>>

    @Query("SELECT * FROM taskList_table WHERE id=:id")
    fun getListTitle(id: Int): LiveData<List<TaskListModel>>
}
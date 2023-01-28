package com.example.myapplication.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "task_table")
class TaskModel(
    @PrimaryKey(autoGenerate = true)
    var id: Int,
    @ColumnInfo
    var title: String,
    @ColumnInfo
    var discription: String = "",
    @ColumnInfo
    var date: Long,
    @ColumnInfo
    var list: Int,

    var favorite: Boolean = false,

    var completed: Boolean = false
)
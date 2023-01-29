package com.example.myapplication.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "task_table")
class TaskModel(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,
    @ColumnInfo
    var title: String,
    @ColumnInfo
    var discription: String,
    @ColumnInfo
    var date: Long,
    @ColumnInfo
    var list: Int,

    var favorite: Boolean = false,

    var completed: Boolean = false
) : Serializable
package com.example.myapplication.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "taskList_table")

class TaskListModel (
    @PrimaryKey(autoGenerate = true)
    var id: Int,
    @ColumnInfo
    var title: String
)
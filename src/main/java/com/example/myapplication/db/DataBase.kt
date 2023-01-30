package com.example.myapplication.db

import android.content.Context
import androidx.room.AutoMigration
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.myapplication.db.dao.TaskDao
import com.example.myapplication.db.dao.TaskListDao
import com.example.myapplication.model.TaskListModel
import com.example.myapplication.model.TaskModel

@Database(
    entities = [TaskModel::class, TaskListModel::class],
    version = 1,
    autoMigrations = [
        AutoMigration (
            from = 1,
            to = 2
        )
    ])
abstract class DataBase: RoomDatabase() {
    abstract fun getTaskDao(): TaskDao
    abstract fun getTaskListDao(): TaskListDao

    companion object {
        private var database: DataBase ?= null

        @Synchronized
        fun getInstance(context: Context):DataBase{
            return if (database == null){
                database = Room.databaseBuilder(context, DataBase::class.java, "_db_")
                    .addMigrations()
                    .build()

                database as DataBase
            }else{
                database as DataBase
            }
        }
    }
}
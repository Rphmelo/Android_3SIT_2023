package br.com.fiap.todoapp.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import br.com.fiap.todoapp.TaskStatus

const val TASK_MODEL_TABLE_NAME = "taskTable"
@Entity(tableName = TASK_MODEL_TABLE_NAME)
data class TaskModel(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    @ColumnInfo
    val title: String,
    @ColumnInfo
    val status: TaskStatus
)
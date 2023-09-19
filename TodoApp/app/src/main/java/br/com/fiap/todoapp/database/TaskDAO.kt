package br.com.fiap.todoapp.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import br.com.fiap.todoapp.TaskStatus

@Dao
interface TaskDAO {

    @Query("SELECT * FROM $TASK_MODEL_TABLE_NAME WHERE status == :statusParam")
    suspend fun selectByStatus(statusParam: TaskStatus): List<TaskModel>

    @Query("SELECT * FROM $TASK_MODEL_TABLE_NAME")
    suspend fun selectAll(): List<TaskModel>

    @Insert
    suspend fun insert(taskModel: TaskModel)
}
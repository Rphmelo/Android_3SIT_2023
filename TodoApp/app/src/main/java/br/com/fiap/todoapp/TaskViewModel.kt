package br.com.fiap.todoapp

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import br.com.fiap.todoapp.database.AppDatabase
import br.com.fiap.todoapp.database.TaskModel

class TaskViewModel(private val application: Application) : AndroidViewModel(application) {

    var selectedFilter: TaskStatus? = null

    suspend fun selectAll(): List<TaskModel> {
        return AppDatabase.getDatabase(
            application.applicationContext
        ).taskDAO().selectAll()
    }

    suspend fun selectByStatus(status: TaskStatus): List<TaskModel> {
        return AppDatabase.getDatabase(
            application.applicationContext
        ).taskDAO().selectByStatus(status)
    }
}
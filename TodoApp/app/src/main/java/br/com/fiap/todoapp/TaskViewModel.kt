package br.com.fiap.todoapp

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import br.com.fiap.todoapp.database.AppDatabase
import br.com.fiap.todoapp.database.TaskModel

class TaskViewModel(application: Application) : AndroidViewModel(application) {

    var selectedFilter: TaskStatus? = null

    private val appDb by lazy {
        AppDatabase.getDatabase(application.applicationContext)
    }

    fun selectAll(): List<TaskModel> {
        return appDb.taskDAO().selectAll()
    }

    fun selectByStatus(status: TaskStatus): List<TaskModel> {
        return appDb.taskDAO().selectByStatus(status)
    }
}
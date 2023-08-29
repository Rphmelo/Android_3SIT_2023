package br.com.fiap.todoapp.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import br.com.fiap.todoapp.TaskStatus

const val TABLE_NAME = "TASK_DATABASE"

@Database(entities = [TaskModel::class], version = 1)
abstract class AppDatabase: RoomDatabase() {

    abstract fun taskDAO(): TaskDAO

    companion object {
        private var INSTANCE: AppDatabase? = null
        fun getDatabase(context: Context): AppDatabase {
            if(INSTANCE != null) {
                return INSTANCE!!
            } else {
                val instance = Room.databaseBuilder(
                    context,
                    AppDatabase::class.java,
                    TABLE_NAME
                ).allowMainThreadQueries() //nao façam isso em casa
                    .build()
                INSTANCE = instance

                val taskList = listOf(
                    TaskModel(title = "Lavar a louça", status = TaskStatus.PENDING),
                    TaskModel(title = "Estudar Android", status = TaskStatus.COMPLETED),
                    TaskModel(title = "Fazer o mercado do mês", status = TaskStatus.COMPLETED),
                    TaskModel(title = "Estudar Flutter", status = TaskStatus.PROGRESS),
                    TaskModel(title = "Fazer o Challenge Sprint", status = TaskStatus.PROGRESS),
                    TaskModel(title = "Pagar os boletos", status = TaskStatus.PENDING),
                    TaskModel(title = "Fazer revisão no carro", status = TaskStatus.COMPLETED),
                    TaskModel(title = "Consertar a porta do quarto ", status = TaskStatus.PROGRESS),
                    TaskModel(title = "Estudar música", status = TaskStatus.PENDING)
                )

                if(INSTANCE?.taskDAO()?.selectAll()?.isEmpty() == true) {
                    taskList.forEach {
                        INSTANCE?.taskDAO()?.insert(it)
                    }
                }
                return instance
            }
        }
    }
}
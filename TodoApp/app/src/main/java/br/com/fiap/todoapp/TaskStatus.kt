package br.com.fiap.todoapp

enum class TaskStatus(val title: String) {
    PENDING("Pendente"),
    PROGRESS("Em andamento"),
    COMPLETED("Concluída");

    companion object {
        fun getByTitle(title: String): TaskStatus {
            return values().find {
                it.title == title
            } ?: PENDING
        }
    }
}
package br.com.fiap.todoapp

enum class TaskStatus(val title: String) {
    PENDING("Pendente"),
    PROGRESS("Em andamento"),
    COMPLETED("Concluída")
}
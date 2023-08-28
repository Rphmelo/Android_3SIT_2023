package br.com.fiap.todoapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import br.com.fiap.todoapp.database.TaskModel
import br.com.fiap.todoapp.databinding.ViewTaskItemBinding

class TaskAdapter : RecyclerView.Adapter<TaskAdapter.TaskViewHolder>() {

    private val taskList: MutableList<TaskModel> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val binding = ViewTaskItemBinding.bind(
            LayoutInflater.from(parent.context).inflate(
                R.layout.view_task_item,
                parent,
                false
            )
        )
        return TaskViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        holder.bindView( taskList[position])
    }

    override fun getItemCount(): Int {
        return taskList.size
    }

    fun setData(list: List<TaskModel>) {
        taskList.clear()
        taskList.addAll(list)

        notifyDataSetChanged()
    }

    inner class TaskViewHolder(
        private val view: ViewTaskItemBinding
    ) : RecyclerView.ViewHolder(view.root) {

        fun bindView(item: TaskModel) {
            view.taskTitle.text = item.title
            view.taskStatus.text = item.status.title

            val statusColor = when(item.status) {
                TaskStatus.PROGRESS -> {
                    R.color.progress
                }
                TaskStatus.PENDING -> {
                    R.color.pending
                }
                TaskStatus.COMPLETED -> {
                    R.color.completed
                }
            }
            view.taskStatus.setTextColor(
                ContextCompat.getColor(view.root.context, statusColor)
            )
        }
    }
}
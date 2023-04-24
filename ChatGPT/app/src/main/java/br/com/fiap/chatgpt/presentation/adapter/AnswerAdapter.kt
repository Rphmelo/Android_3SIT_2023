package br.com.fiap.chatgpt.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import br.com.fiap.chatgpt.R
import br.com.fiap.chatgpt.data.AnswerModel
import br.com.fiap.chatgpt.databinding.ViewAnswerItemBinding

class AnswerAdapter(
    private val answerList: List<AnswerModel>,
    private val shareAction: (String) -> Unit
) : RecyclerView.Adapter<AnswerAdapter.AnswerViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnswerViewHolder {
        return AnswerViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.view_answer_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: AnswerViewHolder, position: Int) {
        holder.bind(answerList[position])
    }

    override fun getItemCount() = answerList.size

    inner class AnswerViewHolder(
        itemView: View
    ) : RecyclerView.ViewHolder(itemView) {

        private val binding = ViewAnswerItemBinding.bind(itemView)

        fun bind(item: AnswerModel) {
            binding.answerValue.text = item.answer
            binding.buttonShareMessage.isVisible = item.hasShareAction
            binding.buttonShareMessage.setOnClickListener {
                shareAction.invoke(item.answer)
            }
        }
    }
}
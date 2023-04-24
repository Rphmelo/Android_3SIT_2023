package br.com.fiap.chatgpt.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.fiap.chatgpt.R
import br.com.fiap.chatgpt.data.TalkModel
import br.com.fiap.chatgpt.databinding.ViewQuestionItemBinding

class QuestionAdapter(
    private val talkList: List<TalkModel>,
    private val onCardClick: (TalkModel) -> Unit
) :
    RecyclerView.Adapter<QuestionAdapter.QuestionViewHolder>() {

    inner class QuestionViewHolder(
        itemView: View
    ): RecyclerView.ViewHolder(itemView) {
        private val binding = ViewQuestionItemBinding.bind(itemView)

        fun bind(item: TalkModel) {
            binding.questionTitle.text = item.question
            binding.root.setOnClickListener {
                onCardClick.invoke(item)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuestionViewHolder {
        return QuestionViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.view_question_item, parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: QuestionViewHolder, position: Int) {
        holder.bind(talkList[position])
    }

    override fun getItemCount(): Int {
        return talkList.size
    }
}
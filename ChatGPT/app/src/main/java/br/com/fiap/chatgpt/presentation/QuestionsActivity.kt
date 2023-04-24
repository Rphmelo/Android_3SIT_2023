package br.com.fiap.chatgpt.presentation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.fiap.chatgpt.data.TalkDataSource
import br.com.fiap.chatgpt.data.TalkModel
import br.com.fiap.chatgpt.databinding.ActivityQuestionsBinding
import br.com.fiap.chatgpt.presentation.AnswersActivity.Companion.TALK_MODEL_KEY
import br.com.fiap.chatgpt.presentation.adapter.QuestionAdapter

class QuestionsActivity : AppCompatActivity() {

    lateinit var binding: ActivityQuestionsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuestionsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        binding.recyclerViewQuestions.adapter = QuestionAdapter(
            TalkDataSource.talkList,
            ::goToAnswersActivity
        )
    }

    private fun goToAnswersActivity(talkModel: TalkModel) {
        startActivity(
            Intent(
                this,
                AnswersActivity::class.java
            ).putExtra(TALK_MODEL_KEY, talkModel)
        )
    }

}
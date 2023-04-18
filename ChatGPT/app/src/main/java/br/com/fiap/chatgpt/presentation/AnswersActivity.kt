package br.com.fiap.chatgpt.presentation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.fiap.chatgpt.R
import br.com.fiap.chatgpt.data.TalkModel
import br.com.fiap.chatgpt.databinding.ActivityAnswersBinding
import br.com.fiap.chatgpt.presentation.adapter.AnswerAdapter

class AnswersActivity : AppCompatActivity() {

    lateinit var binding: ActivityAnswersBinding
    private val talkModel by lazy {
        intent.extras?.getSerializable(TALK_MODEL_KEY) as TalkModel
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAnswersBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupRecyclerView()
        binding.textInputEditTextQuestion.setText(talkModel.question)
    }

    private fun setupRecyclerView() {
        talkModel?.answers?.let {
            binding.recyclerViewAnswers.adapter = AnswerAdapter(
                it,
                ::callImplicitIntent
            )
        }
    }

    private fun callImplicitIntent(messageValue: String) {
        val sendIntent: Intent = Intent().apply {
            action = Intent.ACTION_SEND
            type = "text/plain"
            putExtra(
                Intent.EXTRA_TEXT,
                messageValue
            )
        }

        val shareIntent = Intent.createChooser(
            sendIntent,
            getString(R.string.chooser_title)
        )

        startActivity(shareIntent)
    }

    companion object {
        const val TALK_MODEL_KEY = "TALK_MODEL_KEY"
    }
}
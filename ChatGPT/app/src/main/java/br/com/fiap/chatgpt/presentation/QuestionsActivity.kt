package br.com.fiap.chatgpt.presentation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.fiap.chatgpt.databinding.ActivityQuestionsBinding

class QuestionsActivity : AppCompatActivity() {

    lateinit var binding: ActivityQuestionsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuestionsBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    private fun goToAnswersActivity() {
        startActivity(
            Intent(
                this,
                AnswersActivity::class.java
            )
        )
    }

}
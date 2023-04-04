package br.com.fiap.chatgpt

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.fiap.chatgpt.databinding.ActivityChatBinding

class ChatActivity : AppCompatActivity() {

    lateinit var binding: ActivityChatBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChatBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupButtons()
        binding.textInputEditTextMessage.setText(
            intent.extras?.getString(Intent.EXTRA_TEXT)
        )
    }

    private fun setupButtons() {
        binding.buttonSendMessage.setOnClickListener {
            binding.messageValue.text = binding.textInputEditTextMessage.text
            clearText()
        }

        binding.buttonShareMessage.setOnClickListener {
            val sendIntent: Intent = Intent().apply {
                action = Intent.ACTION_SEND
                type = "text/plain"
                putExtra(Intent.EXTRA_TEXT, binding.messageValue.text.toString())
            }

            val shareIntent = Intent.createChooser(
                sendIntent,
                getString(R.string.chooser_title)
            )

            startActivity(shareIntent)
        }
    }

    private fun clearText() {
        binding.textInputEditTextMessage.text?.clear()
    }

}
package br.com.fiap.chatgpt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.fiap.chatgpt.databinding.ActivityChatBinding

class ChatActivity : AppCompatActivity() {

    lateinit var binding: ActivityChatBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChatBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}
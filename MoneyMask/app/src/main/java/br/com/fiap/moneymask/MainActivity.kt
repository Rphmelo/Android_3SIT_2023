package br.com.fiap.moneymask

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import br.com.fiap.moneymask.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

//    val toggleButton: Button = findViewById(R.id.toggle_button)
//    val moneyCurrency: TextView = findViewById(R.id.money_currency)
//    val moneyValue: TextView = findViewById(R.id.money_value)
    lateinit var binding: ActivityMainBinding
    private val mask: String = "*******"
    private val value: String? = null
    private val isShowing: Boolean = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        toggleButton.setText("Teste")
//        moneyCurrency.setText("Teste")
//        moneyValue.setText("Teste")

//        toggle_button.setText("Teste")
//        money_currency.setText("Teste")
//        money_value.setText("Teste")
        binding = ActivityMainBinding.inflate(layoutInflater)
        binding.toggleButton.setOnClickListener {

        }
        setContentView(binding.root)
    }
}
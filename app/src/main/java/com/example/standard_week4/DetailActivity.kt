package com.example.standard_week4

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.standard_week4.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {
    companion object{
        const val EXTRA_ID = "extra_id"
        const val EXTRA_CARD = "extra_card"
    }

    private val binding by lazy { ActivityDetailBinding.inflate(layoutInflater) }
    private val cardViewModel by viewModels<CardViewModel> {
        CardViewModel.CardViewModelFactory()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val cardId = intent.getLongExtra(EXTRA_ID, 0)
        val cardData = cardViewModel.getCardForId(cardId)

        val text ="Owner: " + cardData.owner +
                "\nCard Number: " + cardData.cardNumber +
                "\nDate: " + cardData.cardDate +
                "\nBalance: $" + decimalFormat.format(cardData.cardValue) +
                "\nCard Type: " + cardData.cardType
        binding.text1.text = text
    }
}
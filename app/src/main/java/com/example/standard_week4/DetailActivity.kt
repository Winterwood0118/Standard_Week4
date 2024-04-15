package com.example.standard_week4

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.standard_week4.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {
    private val binding by lazy { ActivityDetailBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val cardData = intent.getParcelableExtra("data") ?: cardList[0]

        val text ="Owner: " + cardData.owner +
                "\nCard Number: " + cardData.cardNumber +
                "\nDate: " + cardData.cardDate +
                "\nBalance: $" + decimalFormat.format(cardData.cardValue) +
                "\nCard Type" + cardData.cardType
        binding.text1.text = text
    }
}
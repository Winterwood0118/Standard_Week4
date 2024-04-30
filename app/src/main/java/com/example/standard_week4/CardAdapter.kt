package com.example.standard_week4

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.standard_week4.databinding.ItemCardBlueBinding

class CardAdapter(private val onClick: (Card) -> Unit) :
    RecyclerView.Adapter<CardAdapter.CardHolder>() {
    var cardList = listOf<Card>()

    inner class CardHolder(
        private val binding: ItemCardBlueBinding,
        val onClick: (Card) -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {
        private var currentCard: Card? = null

        init {
            itemView.setOnClickListener {
                currentCard?.let {
                    onClick(it)
                }
            }
        }

        fun bind(card: Card) {
            with(binding) {
                currentCard = card
                nameTextView.text = card.owner
                numberTextView.text = card.cardNumber
                dateTextView.text = card.cardDate
                val value = "$" + decimalFormat.format(card.cardValue)
                valueTextView.text = value
            }
        }

    }

    override fun getItemViewType(position: Int): Int {
        return cardList[position].mode.viewType
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardAdapter.CardHolder {
        return when (viewType) {
            MultiMode.BLUE.viewType -> {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_card_blue, parent, false)
                CardHolder(ItemCardBlueBinding.bind(view), onClick)
            }

            MultiMode.SKY_BLUE.viewType -> {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_card_sky, parent, false)
                CardHolder(ItemCardBlueBinding.bind(view), onClick)
            }

            MultiMode.ORANGE.viewType -> {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_card_orange, parent, false)
                CardHolder(ItemCardBlueBinding.bind(view), onClick)
            }

            else -> throw IllegalArgumentException("Unknown View Type")
        }
    }

    override fun getItemCount(): Int {
        return cardList.size
    }

    override fun onBindViewHolder(holder: CardAdapter.CardHolder, position: Int) {
        holder.bind(cardList[position])
    }
}
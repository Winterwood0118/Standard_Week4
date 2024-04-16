package com.example.standard_week4

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.standard_week4.databinding.ItemCardBlueBinding

class CardAdapter2(private val onClick: (Card) -> Unit) :
    RecyclerView.Adapter<CardAdapter2.CardHolder>() {
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
        return cardList[position].backgroundType
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardAdapter2.CardHolder {
        return when (viewType) {
            MULTI_TYPE1 -> {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_card_blue, parent, false)
                CardHolder(ItemCardBlueBinding.bind(view), onClick)
            }

            MULTI_TYPE2 -> {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_card_sky, parent, false)
                CardHolder(ItemCardBlueBinding.bind(view), onClick)
            }

            else -> {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_card_orange, parent, false)
                CardHolder(ItemCardBlueBinding.bind(view), onClick)
            }
        }
    }

    override fun getItemCount(): Int {
        return cardList.size
    }

    override fun onBindViewHolder(holder: CardAdapter2.CardHolder, position: Int) {
        holder.bind(cardList[position])
    }
}
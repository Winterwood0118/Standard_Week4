package com.example.standard_week4

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.standard_week4.databinding.ItemCardBlueBinding
import com.example.standard_week4.databinding.ItemCardOrangeBinding
import com.example.standard_week4.databinding.ItemCardSkyBinding
import com.example.standard_week4.databinding.UnknownItemBinding

class CardAdapter(private val onClick: (Card) -> Unit) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    var cardList = listOf<Card>()

    class UnknownViewHolder(
        binding: UnknownItemBinding
    ): RecyclerView.ViewHolder(binding.root){
        fun bind() = Unit
    }
    override fun getItemViewType(position: Int): Int {
        return cardList[position].mode.viewType
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val multiModeViewType = MultiMode.entries.find { it.viewType == viewType }
        return when (multiModeViewType) {
            MultiMode.BLUE -> {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_card_blue, parent, false)
                BlueCardHolder(ItemCardBlueBinding.bind(view), onClick)
            }

            MultiMode.SKY_BLUE -> {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_card_sky, parent, false)
                SkyBlueCardHolder(ItemCardSkyBinding.bind(view), onClick)
            }

            MultiMode.ORANGE -> {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_card_orange, parent, false)
                OrangeCardHolder(ItemCardOrangeBinding.bind(view), onClick)
            }

            else -> {
                val binding = UnknownItemBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
                UnknownViewHolder(binding)
            }
        }
    }

    override fun getItemCount(): Int {
        return cardList.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val currentItem = cardList[position]
        val multiModeViewType = MultiMode.entries.find { it.viewType == currentItem.mode.viewType }
        when(multiModeViewType){
            MultiMode.BLUE -> {
                (holder as BlueCardHolder).bind(currentItem)
            }
            MultiMode.SKY_BLUE -> {
                (holder as SkyBlueCardHolder).bind(currentItem)
            }
            MultiMode.ORANGE -> {
                (holder as OrangeCardHolder).bind(currentItem)
            }
            else -> {
                (holder as UnknownViewHolder).bind()
            }
        }
    }

    class BlueCardHolder(
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

    class SkyBlueCardHolder(
        private val binding: ItemCardSkyBinding,
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

    class OrangeCardHolder(
        private val binding: ItemCardOrangeBinding,
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
}
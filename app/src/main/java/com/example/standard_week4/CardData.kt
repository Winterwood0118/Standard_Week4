package com.example.standard_week4

class CardData {
    companion object{
        private var INSTANCE: CardData? = null
        fun getInstance(): CardData{
            return INSTANCE?: CardData().apply { INSTANCE = this }
        }
    }
    fun getCardList():List<Card> = cardList
}
package com.example.standard_week4

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class CardViewModel(val cardData: CardData): ViewModel() {
    val cardLiveData = cardData.getCardList()
    fun getCardForId(id: Long): Card{
        return cardLiveData[id.toInt()]
    }

    class CardViewModelFactory: ViewModelProvider.Factory{
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(CardViewModel::class.java)){
                return CardViewModel(CardData.getInstance()) as T
            }
            throw IllegalArgumentException("Wrong ViewModel")
        }
    }
}
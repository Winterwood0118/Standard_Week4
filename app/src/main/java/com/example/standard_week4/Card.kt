package com.example.standard_week4

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Card(
    val cardNumber: String,
    val cardDate: String,
    val cardType: String,
    val cardValue: Double,
    val backgroundType: Int
): Parcelable


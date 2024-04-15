package com.example.standard_week4

import java.text.DecimalFormat

val decimalFormat = DecimalFormat("#,###.00")

val cardList = listOf(
    Card("2423  3581  9503  2412",
        "12/24",
        "A Debit Card",
        1234.11,
        MULTI_TYPE1
    ),
    Card("1234  5678  9098  7654",
        "02/31",
        "A Debit Card",
        657.0,
        MULTI_TYPE2
    ),    Card("0000  0000  0000  0000",
        "11/13",
        "A Debit Card",
        22224.11,
        MULTI_TYPE3
    ),
)
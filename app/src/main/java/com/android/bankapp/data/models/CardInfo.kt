package com.android.bankapp.data.models

data class CardInfo(
    val bankName: String,
    val cardType: String,
    val cardHolderName: String,
    val expiryDate: String,
    val cardNumber: String,
    val hasChip: Boolean,
    val cardBalance: String,
    val currency: String
) {
    companion object {
        fun fakeCard(): CardInfo {
            return CardInfo(
                "Yes Bank",
                "Visa",
                "Pradeep L S",
                "03/25",
                "4521 7896 5412 3698",
                true,
                "9800.27",
                "$"
            )
        }
    }
}

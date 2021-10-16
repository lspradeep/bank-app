package com.android.bankapp.data.models

import androidx.annotation.DrawableRes
import com.android.bankapp.R

data class RecentTransaction(
    @DrawableRes val icon: Int,
    val name: String,
    val credit: Boolean,
    val amount: String
) {
    companion object {
        fun getRecentTransactions(): List<RecentTransaction> {
            return listOf(
                RecentTransaction(
                    R.drawable.ic_apple_music,
                    "Apple Music", false, "7.99"
                ),
                RecentTransaction(
                    R.drawable.ic_youtube,
                    "Youtube Premium", false, "7.99"
                ),
                RecentTransaction(
                    R.drawable.ic_gpay,
                    "Google Pay", true, "12"
                ),
                RecentTransaction(
                    R.drawable.ic_apple_music,
                    "Apple Music", false, "7.99"
                ),
                RecentTransaction(
                    R.drawable.ic_youtube,
                    "Youtube Premium", false, "7.99"
                ),
                RecentTransaction(
                    R.drawable.ic_gpay,
                    "Google Pay", false, "31"
                ),
                RecentTransaction(
                    R.drawable.ic_gpay,
                    "Google Pay", true, "1200"
                ),
            )
        }
    }
}
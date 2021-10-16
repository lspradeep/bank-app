package com.android.bankapp.data.models

import androidx.annotation.DrawableRes
import com.android.bankapp.R

data class NavItem(
    @DrawableRes val icon: Int,
    val label: String,
    val id: Int
) {
    companion object {
        fun getNavItems(): List<NavItem> {
            return listOf(
                NavItem(
                    R.drawable.ic_icon_home,
                    "Home",
                    0
                ),
                NavItem(
                    R.drawable.img_bank,
                    "Transfer",
                    1
                ),
                NavItem(
                    R.drawable.img_chart,
                    "Expense",
                    2
                ),
                NavItem(
                    R.drawable.img_history,
                    "History",
                    3
                ),
                NavItem(
                    R.drawable.img_graph,
                    "Invest",
                    4
                )
            )
        }
    }
}

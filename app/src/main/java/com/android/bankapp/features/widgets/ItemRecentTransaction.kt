package com.android.bankapp.features.widgets

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.android.bankapp.data.models.RecentTransaction
import com.android.bankapp.ui.theme.Typography
import com.android.bankapp.ui.theme.green
import com.android.bankapp.ui.theme.red
import com.android.bankapp.util.Const

@Composable
fun ItemRecentTransaction(
    modifier: Modifier,
    recentTransaction: RecentTransaction
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(top = 4.dp, bottom = 4.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Box(modifier = modifier.size(30.dp)) {
                Image(
                    painter = painterResource(id = recentTransaction.icon),
                    contentDescription = ""
                )
            }

            Spacer(modifier = modifier.width(10.dp))

            Text(
                text = recentTransaction.name,
                style = Typography.body2
            )
        }
        if (recentTransaction.credit) {
            Text(
                text = "+${Const.currency}${recentTransaction.amount}",
                style = Typography.subtitle1.copy(color = green, fontWeight = FontWeight.Bold)
            )
        } else {
            Text(
                text = "-${Const.currency}${recentTransaction.amount}",
                style = Typography.subtitle1.copy(color = red, fontWeight = FontWeight.Bold)
            )
        }
    }
}
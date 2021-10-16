package com.android.bankapp.features.widgets

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.android.bankapp.R
import com.android.bankapp.ui.theme.Typography

@Composable
fun ItemDatePicker(
    modifier: Modifier,
    onClick: () -> Unit,
    date: String
) {
    Box(
        modifier = modifier
            .height(30.dp)
            .border(
                width = 1.dp,
                color = Color.Gray,
                shape = RoundedCornerShape(8.dp)
            )
            .clickable {
                onClick.invoke()
            }, contentAlignment = Alignment.Center
    ) {
        Row(modifier = modifier.padding(start = 10.dp, end = 10.dp)) {
            Text(text = date, style = Typography.subtitle1.copy(color = Color.Gray))

            Icon(
                painter = painterResource(id = R.drawable.ic_baseline_arrow_drop_down_24),
                contentDescription = "",
                tint = Color.Gray
            )
        }
    }
}
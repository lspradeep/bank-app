package com.android.bankapp.features.widgets

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.android.bankapp.R
import com.android.bankapp.data.models.CardInfo
import com.android.bankapp.ui.theme.Typography

@ExperimentalMaterialApi
@Composable
fun CreditCard2(
    modifier: Modifier,
    cardInfo: CardInfo = CardInfo.fakeCard(),
    onClickListener: () -> Unit = {}
) {

    Card(
        onClick = { onClickListener.invoke() },
        modifier = modifier.width(300.dp),
        backgroundColor = MaterialTheme.colors.primaryVariant,
        elevation = 0.dp,
        shape = RoundedCornerShape(12.dp)
    ) {
        Box {
            Image(
                painter = painterResource(id = R.drawable.img_1),
                contentDescription = "",
                modifier = modifier
                    .fillMaxSize()
            )

            Column(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(start = 20.dp, end = 20.dp, top = 10.dp, bottom = 10.dp),
            ) {
                Row(
                    modifier = modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Image(
                        painter = painterResource(id = R.drawable.ic_icons8_visa),
                        contentDescription = "",
                        modifier = modifier.width(40.dp)
                    )

                    Text(
                        text = cardInfo.bankName,
                        style = Typography.subtitle1.copy(fontWeight = FontWeight.Bold)
                    )
                }

                Spacer(modifier = modifier.height(20.dp))

                Row(
                    modifier = modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Text(
                        text = "${cardInfo.currency}${cardInfo.cardBalance}",
                        style = Typography.h5.copy(fontWeight = FontWeight.Bold)
                    )

                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.chip_card),
                            contentDescription = "",
                            modifier = modifier.width(40.dp)
                        )
                        Image(
                            painter = painterResource(id = R.drawable.ic_baseline_wifi_24),
                            contentDescription = "",
                            modifier = modifier
                                .width(20.dp)
                                .rotate(90f)
                        )
                    }

                }

                Spacer(modifier = modifier.height(20.dp))

                Row(
                    modifier = modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = cardInfo.cardHolderName.uppercase(),
                        style = Typography.body2
                    )

                    Text(
                        text = cardInfo.expiryDate,
                        style = Typography.body2
                    )
                }

                Spacer(modifier = modifier.height(10.dp))

                Text(
                    text = cardInfo.cardNumber,
                    style = Typography.subtitle1
                )
            }

        }

    }


}
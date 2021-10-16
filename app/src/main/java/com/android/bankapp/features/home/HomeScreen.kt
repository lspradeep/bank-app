package com.android.bankapp.features.home

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import coil.transform.CircleCropTransformation
import com.android.bankapp.R
import com.android.bankapp.data.models.RecentTransaction
import com.android.bankapp.features.widgets.CreditCard
import com.android.bankapp.features.widgets.CreditCard2
import com.android.bankapp.features.widgets.ItemDatePicker
import com.android.bankapp.features.widgets.ItemRecentTransaction
import com.android.bankapp.ui.theme.CustomOutlinedButton
import com.android.bankapp.ui.theme.Typography

@ExperimentalMaterialApi
@Composable
fun HomeScreen(modifier: Modifier) {
    // A surface container using the 'background' color from the theme
    Surface(
        color = MaterialTheme.colors.background,
    ) {
        LazyColumn(
            contentPadding = PaddingValues(
                start = 16.dp,
                end = 16.dp,
                top = 30.dp,
                bottom = 100.dp
            ),
            modifier = modifier
                .fillMaxSize()
        ) {

            // User Details Name, Profile Pic and Account balance
            item {
                UserDetails(modifier = modifier)
            }

            item {
                Spacer(modifier = modifier.height(30.dp))
            }


            // credit/debit cards row
            item {
                DisplayCards(modifier = modifier)
            }

            item {
                Spacer(modifier = modifier.height(10.dp))
            }

            //send and receive money buttons

            item {
                Row(
                    modifier = modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {

                    CustomOutlinedButton(
                        modifier = modifier
                            .width(0.dp)
                            .weight(1f),
                        onClick = {

                        }
                    ) {
                        Text(
                            text = "Send money",
                            style = Typography.body2.copy(color = MaterialTheme.colors.primary),
                            modifier = modifier,
                        )
                    }

                    Spacer(modifier = modifier.width(10.dp))

                    CustomOutlinedButton(
                        modifier = modifier
                            .width(0.dp)
                            .weight(1f),
                        onClick = {

                        }
                    ) {
                        Text(
                            text = "Request",
                            style = Typography.body2.copy(color = MaterialTheme.colors.primary),
                            modifier = modifier,
                        )
                    }

                }
            }

            item {
                Spacer(modifier = modifier.height(25.dp))
            }

            //recent operations title
            item {
                Row(
                    modifier = modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(text = "Recent operations", style = Typography.subtitle1)

                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        ItemDatePicker(
                            modifier = modifier,
                            onClick = { },
                            date = "17.10.2021"
                        )

                        Spacer(modifier = modifier.width(4.dp))

                        Icon(
                            painter = painterResource(id = R.drawable.ic_baseline_more_horiz_24),
                            contentDescription = "",
                            tint = Color.Gray,
                            modifier = modifier.clickable { }
                        )

                    }
                }
            }

            item {
                Spacer(modifier = modifier.height(8.dp))
            }

            item {
                RecentTransaction.getRecentTransactions().forEach { item ->
                    ItemRecentTransaction(modifier = modifier, recentTransaction = item)

                    Spacer(modifier = modifier.height(4.dp))
                }
            }
        }
    }
}

@ExperimentalMaterialApi
@Composable
fun DisplayCards(modifier: Modifier) {
    val cards = (0..3).toList()
    val lazyListState = rememberLazyListState()

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LazyRow(state = lazyListState) {
            items(items = cards) {
                CreditCard2(modifier = modifier)
                Spacer(modifier = modifier.width(25.dp))
            }
        }

        Spacer(modifier = modifier.height(8.dp))

        LazyRow(
            modifier = modifier,
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            item {
                cards.forEachIndexed { index, i ->
                    Box(
                        modifier = modifier
                            .size(5.dp)
                            .background(
                                color = if (lazyListState.firstVisibleItemIndex == index) MaterialTheme.colors.primary else Color.Gray,
                                shape = RoundedCornerShape(30.dp)
                            )
                    )

                    Spacer(modifier = modifier.width(2.dp))
                }
            }
        }
    }
}

@Composable
fun UserDetails(modifier: Modifier) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column {
            Text(
                text = "Total Balance",
                style = Typography.subtitle1.copy(color = Color.Gray)
            )

            Spacer(modifier = modifier.height(4.dp))

            Text(
                text = "$1345.53",
                style = Typography.h5.copy(fontWeight = FontWeight.ExtraBold)
            )
        }

        Image(
            painter = rememberImagePainter(
                data = "https://images.eatmytickets.com/attraction/image-thumb/attraction_details/1564669378-en-eminem-tour-2020-dates-and-tickets.jpg",
                builder = {
                    transformations(CircleCropTransformation())
                }
            ),
            contentDescription = null,
            modifier = Modifier
                .size(45.dp)
        )
    }
}

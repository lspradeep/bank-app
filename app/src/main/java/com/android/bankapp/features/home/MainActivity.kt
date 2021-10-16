package com.android.bankapp.features.home

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.android.bankapp.R
import com.android.bankapp.data.models.NavItem
import com.android.bankapp.ui.theme.BankAppTheme
import com.android.bankapp.ui.theme.lightGray

class MainActivity : ComponentActivity() {
    @ExperimentalMaterialApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val modifier = Modifier

        setContent {
            val navState = remember {
                mutableStateOf(
                    NavItem(
                        R.drawable.ic_icon_home,
                        "Home",
                        0
                    )
                )
            }

            BankAppTheme {
                Scaffold(bottomBar = {
                    BottomAppBar(backgroundColor = lightGray) {
                        Row(modifier = modifier) {
                            CreateBottomNavigation(
                                modifier = modifier,
                                navItems = NavItem.getNavItems(),
                                listener = { item ->
                                    navState.value = item
                                },
                                selectedIndex = navState.value.id
                            )
                        }
                    }
                }) {
                    HomeScreen(modifier = modifier)
                }
            }
        }
    }

    @Composable
    fun CreateBottomNavigation(
        modifier: Modifier,
        navItems: List<NavItem>,
        listener: (NavItem) -> Unit,
        selectedIndex: Int
    ) {
        Row {
            navItems.forEach { item ->
                BottomNavigationItem(
                    modifier = modifier
                        .background(
                            color = (if (item.id == selectedIndex) MaterialTheme.colors.primary else Color.Transparent),
                            shape = RoundedCornerShape(18.dp)
                        ).width(45.dp),
                    selected = (item.id == selectedIndex),
                    onClick = { listener.invoke(item) },
                    icon = {
                        Icon(
                            painter = painterResource(id = item.icon),
                            contentDescription = ""
                        )
                    },
                    label = { Text(text = item.label) },
                    selectedContentColor = Color.White,
                    unselectedContentColor = MaterialTheme.colors.primary,
                )
            }
        }
    }
}
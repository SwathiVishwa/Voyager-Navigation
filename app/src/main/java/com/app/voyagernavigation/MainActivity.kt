package com.app.voyagernavigation

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import cafe.adriel.voyager.core.registry.ScreenRegistry
import cafe.adriel.voyager.navigator.tab.CurrentTab
import cafe.adriel.voyager.navigator.tab.LocalTabNavigator
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabNavigator
import com.app.voyagernavigation.ui.SharedScreen
import com.app.voyagernavigation.ui.screens.ItemDetailsScreen
import com.app.voyagernavigation.ui.screens.ItemScreen
import com.app.voyagernavigation.ui.tab.FavouritesTab
import com.app.voyagernavigation.ui.tab.HomeTab
import com.app.voyagernavigation.ui.tab.ProfileTab

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TabNavigator(HomeTab) {

                Scaffold(
                    content = {
                        CurrentTab()
                    },
                    bottomBar = {
                        BottomNavigation(backgroundColor = Color.White, contentColor = Color.Gray) {
                            TabNavigationItem(HomeTab)
                            TabNavigationItem(FavouritesTab)
                            TabNavigationItem(ProfileTab)
                        }
                    }
                )
            }
        }
    }
}


@Composable
private fun RowScope.TabNavigationItem(tab: Tab) {
    val tabNavigator = LocalTabNavigator.current

    BottomNavigationItem(
        selected = tabNavigator.current == tab,
        onClick = { tabNavigator.current = tab },
        selectedContentColor = Color.Blue,
        unselectedContentColor = Color.Black,
        icon = {
            Column(
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Icon(painter = tab.options.icon!!, contentDescription = tab.options.title)
                Text(tab.options.title)
            }
        }
    )
}
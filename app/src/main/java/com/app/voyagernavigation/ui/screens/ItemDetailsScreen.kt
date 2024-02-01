package com.app.voyagernavigation.ui.screens

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.screen.Screen

data class ItemDetailsScreen(
    val id: String
) : Screen {

    @Composable
    override fun Content() {


        Text("Post Screen")
        Text(text = id)
    }
}
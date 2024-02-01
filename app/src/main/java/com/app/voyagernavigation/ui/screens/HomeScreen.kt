package com.app.voyagernavigation.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.registry.rememberScreen
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.app.voyagernavigation.ui.SharedScreen

class HomeScreen : Screen {

    @Composable
    override fun Content() {


        val navigators = LocalNavigator.currentOrThrow
        val postListScreen = rememberScreen(SharedScreen.ItemList)
        val postDetailsScreen = rememberScreen(SharedScreen.ItemDetails(id = "postId"))

        Column(
            modifier = Modifier
                .padding(10.dp), horizontalAlignment = Alignment.CenterHorizontally
        ) {


            Spacer(modifier = Modifier.height(200.dp))
            Text(
                text = "Post",
                modifier = Modifier.clickable { navigators.push(postDetailsScreen) })

            Spacer(modifier = Modifier.height(200.dp))
            Text(text = "Post", modifier = Modifier.clickable { navigators.push(postListScreen) })
        }
    }

}
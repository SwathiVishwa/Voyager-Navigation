package com.app.voyagernavigation.ui

import cafe.adriel.voyager.core.registry.ScreenProvider

sealed class SharedScreen : ScreenProvider {
    object ItemList : SharedScreen()
    data class ItemDetails(val id: String) : SharedScreen()
}
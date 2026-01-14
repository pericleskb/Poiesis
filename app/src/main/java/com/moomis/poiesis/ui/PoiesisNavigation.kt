package com.moomis.poiesis.ui

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.ui.graphics.vector.ImageVector

interface PoiesisDestination {
    val icon: ImageVector
    val route: String
    val contentDescription: String
    val label: String
}

object HomeDestination: PoiesisDestination {
    override val icon: ImageVector = Icons.Filled.Home
    override val route = "home"
    override val label = "Home"
    override val contentDescription = "Home Screen"
}

object SearchDestination: PoiesisDestination {
    override val icon: ImageVector = Icons.Filled.Search
    override val route = "search"
    override val label = "Search"
    override val contentDescription = "Search Screen"
}

object FavoritesDestination: PoiesisDestination {
    override val icon: ImageVector = Icons.Filled.Favorite
    override val route = "favorites"
    override val label = "Favorites"
    override val contentDescription = "Favorites Screen"
}

val bottomBarDestinations = listOf(HomeDestination, SearchDestination, FavoritesDestination)
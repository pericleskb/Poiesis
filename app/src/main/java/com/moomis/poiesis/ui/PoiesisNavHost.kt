package com.moomis.poiesis.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.moomis.poiesis.ui.favorites.FavoritesScreen
import com.moomis.poiesis.ui.home.HomeScreen
import com.moomis.poiesis.ui.search.SearchScreen

@Composable
fun PoiesisNavHost(
    navController: NavHostController = rememberNavController(),
    modifier: Modifier = Modifier,
) {
    NavHost(
        navController = navController,
        startDestination = HomeDestination.route,
        modifier = modifier
    ) {
        composable(route = HomeDestination.route) {
            HomeScreen()
        }
        composable(route = SearchDestination.route) {
            SearchScreen()
        }
        composable(route = FavoritesDestination.route) {
            FavoritesScreen()
        }
    }
}
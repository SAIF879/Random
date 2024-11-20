package com.example.random.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.random.mainflow.home.ui.DetailsScreen
import com.example.random.mainflow.home.ui.HomeScreen

fun NavGraphBuilder.homeNavGraph() {

    navigation(
        route = NavGraphs.HOME,
        startDestination = HomeScreens.HomeScreen.route
    ) {

        composable(route = HomeScreens.HomeScreen.route) {
            HomeScreen()
        }
        composable(route = HomeScreens.DetailsScreen.route) {
            DetailsScreen()
        }

    }
}

sealed class HomeScreens(val route: String) {
    data object HomeScreen : HomeScreens("home_screen")
    data object DetailsScreen : HomeScreens("details_screen")
}





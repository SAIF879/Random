package com.example.random.navigation


import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost

@Composable
fun RootNavGraph(navHostController: NavHostController) {
    NavHost(
        navController = navHostController,
        route = NavGraphs.ROOT,
        startDestination = NavGraphs.SPLASH
    ) {

        splashNavGraph(navHostController)
        homeNavGraph()

    }

}

object NavGraphs{
    const val ROOT = "root_graph"
    const val SPLASH = "splash_graph"
    const val HOME = "home_graph"
}

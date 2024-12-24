package com.example.random.navigation

import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.random.mainflow.home.ui.DetailsScreen
import com.example.random.mainflow.home.ui.HomeScreen
import com.example.random.mainflow.home.util.HomeRepository
import com.example.random.mainflow.home.util.HomeViewModel
import com.example.random.network.RetrofitInstance

fun NavGraphBuilder.homeNavGraph() {
//
//    navigation(
//        route = NavGraphs.HOME,
//        startDestination = HomeScreens.HomeScreen.route
//    ) {
//
//
//        composable(route = HomeScreens.HomeScreen.route) {
//            val repo = HomeRepository(RetrofitInstance.apiService)
//           val homeViewModel = HomeViewModel(repo)
//            HomeScreen(homeViewModel = homeViewModel)
//        }
//        composable(route = HomeScreens.DetailsScreen.route) {
//            DetailsScreen()
//        }
//
//    }


        navigation(
            route = NavGraphs.HOME,
            startDestination = HomeScreens.HomeScreen.route
        ) {
            composable(route = HomeScreens.HomeScreen.route) {
                val context = LocalContext.current
                // Use viewModel() to get the HomeViewModel scoped to the HomeScreen
                val homeViewModel: HomeViewModel = viewModel(factory = object : ViewModelProvider.Factory {
                    override fun <T : ViewModel> create(
                        modelClass: Class<T>,
                        extras: CreationExtras
                    ): T {
                        return HomeViewModel(context) as T
                    }
                }) // You can use a ViewModel factory if necessary
                HomeScreen(homeViewModel = homeViewModel)
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





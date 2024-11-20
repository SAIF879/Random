package com.example.random.mainflow.home.ui

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.random.mainflow.home.util.HomeViewModel
import com.example.random.network.ApiResult

@Composable
fun HomeScreen(homeViewModel: HomeViewModel) {


val pokemonList = homeViewModel.pokemonList.observeAsState(ApiResult.Loading)

    when(pokemonList.value){
        is ApiResult.Error -> {
            Log.d(Tags.HomeScreen.tag, "${pokemonList.value.message}: ")
        }
        ApiResult.Loading -> {
            Log.d(Tags.HomeScreen.tag, "${pokemonList.value.status} ")

        }
        is ApiResult.Success -> {
            Log.d(Tags.HomeScreen.tag, "${pokemonList.value.data} ")
        }
    }

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {




    }
}


@Composable
fun PokemonCard(){
    Card(modifier = Modifier
        .fillMaxWidth()
        .height(100.dp)
        .padding(10.dp)) {

    }
}

sealed class Tags(val tag: String) {
    data object HomeScreen : Tags("HomeScreen")
}

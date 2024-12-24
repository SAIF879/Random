package com.example.random.mainflow.home.util

import android.content.Context
import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.random.network.ApiResult
import com.example.random.network.data.PokemonResult
import kotlinx.coroutines.launch



class HomeViewModel(context: Context) : ViewModel() {
    private val  repository= HomeRepository(context)
    private val _pokemonList = MutableLiveData<ApiResult<List<PokemonResult>>>(ApiResult.Loading)
    val pokemonList: LiveData<ApiResult<List<PokemonResult>>> get() = _pokemonList

    fun getPokemonList() {
        viewModelScope.launch {
            Log.d("HomeViewModel", "Fetching Pokemon List...")
            _pokemonList.value = ApiResult.Loading // Set loading state
            try {
                val result = repository.getPokemonList() // Fetch data from the repository
                _pokemonList.value = result // Update LiveData with result (success or error)
                Log.d("HomeViewModel", "Result: $result")
            } catch (e: Exception) {
                _pokemonList.value = ApiResult.Error("Failed to fetch data: ${e.localizedMessage}")
                Log.e("HomeViewModel", "Error: ${e.localizedMessage}")
            }
        }
    }
}

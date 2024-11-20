package com.example.random.mainflow.home.util

import androidx.compose.runtime.MutableState
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.random.network.ApiResult
import com.example.random.network.data.PokemonResult
import kotlinx.coroutines.launch

class HomeViewModel(val repository: HomeRepository) : ViewModel(){
    private val _pokemonList = MutableLiveData<ApiResult<List<PokemonResult>>>()
    val pokemonList: MutableLiveData<ApiResult<List<PokemonResult>>> get() = _pokemonList

    fun getPokemonList(){
        viewModelScope.launch {
            _pokemonList.value = ApiResult.Loading
            _pokemonList.value = repository.getPokemonList()
        }
    }
}
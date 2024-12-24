package com.example.random.mainflow.home.util

import android.content.Context
import android.util.Log
import com.example.random.network.ApiResult
import com.example.random.network.CommonApiServices
import com.example.random.network.RetrofitInstance
import com.example.random.network.data.PokemonResult

class HomeRepository(context : Context) {
    private val commonApiServices: CommonApiServices = RetrofitInstance.getApiService(context)

    suspend fun getPokemonList(): ApiResult<List<PokemonResult>> {
        return try {
            val pokemonData = commonApiServices.getPokemonList()
            if (pokemonData.isSuccessful) {
                // Log the response for debugging
                Log.d("HomeRepository", "API Response: ${pokemonData.body()}")
                ApiResult.Success(pokemonData.body() ?: emptyList())
            } else {
                // Log error message from the server
                Log.e("HomeRepository", "Error: ${pokemonData.message()}")
                ApiResult.Error("Error: ${pokemonData.message()}")
            }
        } catch (e: Exception) {
            Log.e("HomeRepository", "Exception: ${e.localizedMessage}")
            ApiResult.Error(e.localizedMessage ?: "Unknown error")
        }
    }
}


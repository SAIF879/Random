package com.example.random.mainflow.home.util

import com.example.random.network.ApiResult
import com.example.random.network.CommonApiServices
import com.example.random.network.data.PokemonResult


class HomeRepository(val commonApiServices: CommonApiServices){

    suspend fun getPokemonList(): ApiResult<List<PokemonResult>>{
        return try{
            val pokemonData = commonApiServices.getPokemonList()
            if (pokemonData.isSuccessful){
                ApiResult.Success(pokemonData.body())
            }else{
                ApiResult.Error("Error")
            }
        }catch (e:Exception){
            ApiResult.Error(e.localizedMessage ?: "Unknown error")
        }
    }
}


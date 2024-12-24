package com.example.random.network

import com.example.random.network.data.PokemonResponse
import com.example.random.network.data.PokemonResult
import retrofit2.Response
import retrofit2.http.GET

interface CommonApiServices {

    @GET("/pokemon")
    suspend fun getPokemonList(): Response<List<PokemonResult>>

}
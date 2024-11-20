package com.example.random.network.data

import com.google.gson.annotations.SerializedName

data class PokemonResult(
    @SerializedName("name" ) var name : String? = null,
    @SerializedName("url"  ) var url  : String? = null
)
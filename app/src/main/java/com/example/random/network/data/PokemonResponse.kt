package com.example.random.network.data

import com.google.gson.annotations.SerializedName

data class PokemonResponse (

    @SerializedName("count"    ) var count    : Int?               = null,
    @SerializedName("next"     ) var next     : String?            = null,
    @SerializedName("previous" ) var previous : String?            = null,
    @SerializedName("results"  ) var results  : ArrayList<PokemonResult> = arrayListOf()

)
package com.example.random.network

import android.content.Context
import androidx.compose.ui.platform.LocalContext
import com.chuckerteam.chucker.api.ChuckerInterceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object RetrofitInstance {

    private const val BASE_URL = "https://pokeapi.co/api/v2/"

    // Method to get the Retrofit instance
    fun getRetrofitInstance(context: Context): Retrofit {
        // Setup HttpLoggingInterceptor for basic logging
        val loggingInterceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

        // Setup ChuckerInterceptor for detailed inspection
        val chuckerInterceptor = ChuckerInterceptor.Builder(context)
            .build()

        // Setup OkHttpClient with both interceptors
        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor) // Add logging interceptor
            .addInterceptor(chuckerInterceptor) // Add Chucker interceptor
            .build()

        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient) // Attach client to Retrofit
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    // Method to get the apiService instance
    fun getApiService(context: Context): CommonApiServices {
        return getRetrofitInstance(context).create(CommonApiServices::class.java)
    }
}
package com.example.retrofitdemo

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RetrofitInstance {
    companion object{
        private const val BASE_URL = "https://jsonplaceholder.typicode.com/"

        // Create Logger
        private val logger = HttpLoggingInterceptor().apply {
            this.level = HttpLoggingInterceptor.Level.BODY
        }

        // Create OkHttp Client
        private val okHttp: OkHttpClient = OkHttpClient.Builder().apply {
            this.addInterceptor(logger)
                .connectTimeout(30, TimeUnit.SECONDS)
                .readTimeout(20, TimeUnit.SECONDS)
                .writeTimeout(25, TimeUnit.SECONDS)
        }.build()


        fun getRetrofitInstance(): Retrofit{
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
                .client(okHttp)
                .build()
        }
    }
}
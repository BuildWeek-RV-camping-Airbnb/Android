package com.Lambda.rv_camping.networking

import com.Lambda.rv_camping.model.CampingSpots
import com.Lambda.rv_camping.model.User
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import java.util.concurrent.TimeUnit

interface PlaceApiBuilder {

    @GET("api/properties")
    fun getAllProperties(): Call<List<CampingSpots>>

    companion object{
        const val BASE_URL = "https://bw-rvnb.herokuapp.com/"

        fun create(): PlaceApiBuilder {
            val logger = HttpLoggingInterceptor()
            logger.level = HttpLoggingInterceptor.Level.BASIC
            logger.level = HttpLoggingInterceptor.Level.BODY

            val okHttpClient = OkHttpClient.Builder()
                .addInterceptor(logger)
                .retryOnConnectionFailure(false)
                .readTimeout(10, TimeUnit.SECONDS)
                .connectTimeout(15, TimeUnit.SECONDS)
                .build()

            val retrofit = Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            return retrofit.create(PlaceApiBuilder::class.java)
        }
    }
}
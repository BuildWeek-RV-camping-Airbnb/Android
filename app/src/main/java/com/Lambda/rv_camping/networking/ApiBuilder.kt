package com.Lambda.rv_camping.networking

import com.Lambda.rv_camping.model.*
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*
import java.util.concurrent.TimeUnit

interface ApiBuilder {

    @GET("api/users")
    fun getAllUsers(): Call<List<User>>

    @POST("api/users/login")
    fun login(@Body user: UserLogin): Call<UserResponse>

    @POST("api/users")
    fun createUser(@Body user: User): Call<UserResponse>

    @GET("api/properties")
    fun getAllProperties(@Header("Authorization") authToken: String): Call<Properties>

    // Because the response is nothing, pass in Void into the Call
    @POST("api/properties")
    fun createProperty(@Header("Authorization") authToken: String, @Body newProperty: NewProperty): Call<Void>

    // This used to not work but now it does in the backend
    @DELETE("api/properties/{id}")
    fun deleteProperty(@Header("Authorization") authToken:String,
                       @Path("id")id: Int): Call<Void>


    companion object{
        const val BASE_URL = "https://bw-rvnb.herokuapp.com/"

        fun create(): ApiBuilder {
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

            return retrofit.create(ApiBuilder::class.java)
        }
    }
}
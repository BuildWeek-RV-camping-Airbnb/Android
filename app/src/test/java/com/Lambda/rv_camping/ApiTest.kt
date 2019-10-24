package com.Lambda.rv_camping

import com.Lambda.rv_camping.networking.ApiBuilder
import com.Lambda.rv_camping.networking.PlaceApiBuilder
import okhttp3.OkHttpClient
import okhttp3.internal.http2.Http2Reader.Companion.logger
import okhttp3.logging.HttpLoggingInterceptor
import org.amshove.kluent.should
import org.amshove.kluent.shouldBeEqualTo
import org.amshove.kluent.shouldEqual
import org.amshove.kluent.shouldNotEqual
import org.junit.Test
import org.mockito.Mock
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class ApiTest {

    @Mock
    val api = ApiBuilder

    @Mock
    val placeApiBuilder = PlaceApiBuilder

    @Test
    fun apiBaseFun(){
       val test = api.BASE_URL
        test shouldBeEqualTo "https://bw-rvnb.herokuapp.com/"
    }

    @Test
    fun apiShouldNotFun(){
        val test = api.create()
        test shouldNotEqual api.BASE_URL
    }

    @Test
    fun apiPlace(){
       val test = placeApiBuilder.BASE_URL
        test shouldBeEqualTo "https://bw-rvnb.herokuapp.com/"

    }

    @Test
    fun apiPlaceShouldNotFun(){
        val test = placeApiBuilder.BASE_URL
        test shouldNotEqual api.BASE_URL
    }

}
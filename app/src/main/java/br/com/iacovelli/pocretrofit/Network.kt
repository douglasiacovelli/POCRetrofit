package br.com.iacovelli.pocretrofit

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import java.util.logging.Level


object Network {

    private const val BASE_URL = "https://baseurl/api/"
    private val gson = GsonBuilder()
        .create()


    fun getRetrofitInstance(): Retrofit {
        val client = OkHttpClient.Builder()
            .addInterceptor(getLoggingInterceptor())
            .build()

        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create(gson))
            .baseUrl(BASE_URL)
            .client(client)
            .build()
    }

    private fun getLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
    }

}
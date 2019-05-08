package br.com.iacovelli.pocretrofit

import android.app.Application
import retrofit2.Retrofit

class CustomApplication: Application() {

    lateinit var retrofit: Retrofit

    override fun onCreate() {
        super.onCreate()
        retrofit = Network.getRetrofitInstance()
    }
}
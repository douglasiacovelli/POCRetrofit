package br.com.iacovelli.pocretrofit

import retrofit2.Call
import retrofit2.http.FieldMap
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

@JvmSuppressWildcards
interface TestService {

    @FormUrlEncoded
    @POST("workflow")
    fun sendForm(@FieldMap data: Map<String, Any>): Call<Unit>
}
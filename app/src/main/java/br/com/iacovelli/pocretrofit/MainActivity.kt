package br.com.iacovelli.pocretrofit

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        send_data.setOnClickListener {
            sendRequest()
        }
    }

    private fun sendRequest() {

        val list = listOf(
            ThirdParty("Marcelo", "marcelo@youse.com.br"),
            ThirdParty("Arthur", "arthur@youse.com.br"),
            ThirdParty("Martha", "martha@youse.com.br")
        )

        val map = mapOf(
            "abc" to "123",
            "coverage[abc]" to list
        )

        val service = getRetrofitService()
        service.sendForm(map).enqueue(object: Callback<Unit> {
            override fun onFailure(call: Call<Unit>, t: Throwable) {
                Log.d("e", "Failure on request")
            }

            override fun onResponse(call: Call<Unit>, response: Response<Unit>) {
                Log.d("e", "Successful request")
            }
        })

    }

    private fun getRetrofitService(): TestService {
        return (application as CustomApplication).retrofit.create(TestService::class.java)
    }
}

data class ThirdParty(val name: String, val email: String)

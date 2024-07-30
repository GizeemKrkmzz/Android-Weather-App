package com.example.weatherapp
import okhttp3.Credentials
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    private val client: OkHttpClient = OkHttpClient()
        .newBuilder()
        .addInterceptor { chain ->
            val credentials: String = Credentials.basic("----_altuntas_rasim", "Cqp5bOy5T3")
            val newRequest: Request = chain.request().newBuilder()
                .addHeader("Authorization", credentials)
                .build()
            chain.proceed(newRequest)
        }
        .build()

    private val retrofit by lazy{
        Retrofit.Builder()
            .baseUrl("https://api.meteomatics.com/")
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    val api:SimpleApi by lazy {
        retrofit.create(SimpleApi::class.java)
    }
}
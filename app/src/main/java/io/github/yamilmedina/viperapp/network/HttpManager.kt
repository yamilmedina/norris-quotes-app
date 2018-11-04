package io.github.yamilmedina.viperapp.network

import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object HttpManager {

    private const val PHRASE_BASE_API_URL = "http://api.icndb.com/jokes/"

    private val retrofitBuilder: Retrofit

    init {
        retrofitBuilder = Retrofit.Builder()
                .baseUrl(PHRASE_BASE_API_URL)
                .addConverterFactory(GsonConverterFactory.create(GsonBuilder().setLenient().create()))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
    }

    fun <T> createRemoteService(clazz: Class<T>): T {
        return retrofitBuilder.create(clazz)
    }

}
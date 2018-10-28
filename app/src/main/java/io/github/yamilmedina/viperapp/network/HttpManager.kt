package io.github.yamilmedina.viperapp.network

import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import io.github.yamilmedina.viperapp.phrasefeed.PhraseService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object HttpManager {

    private val PHRASE_BASE_API_URL = "http://api.icndb.com/jokes/"
    lateinit var phraseService: PhraseService

    fun createPhraseService() {
        val gson = GsonBuilder().setLenient().create()

        val retrofitBuilder = Retrofit.Builder()
                .baseUrl(PHRASE_BASE_API_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()

        phraseService = retrofitBuilder.create(PhraseService::class.java)
    }


}
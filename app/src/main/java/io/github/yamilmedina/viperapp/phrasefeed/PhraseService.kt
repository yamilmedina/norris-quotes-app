package io.github.yamilmedina.viperapp.phrasefeed

import io.github.yamilmedina.viperapp.data.PhraseResultEntity
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface PhraseService {

    @GET("random/{quantity}")
    fun fetchRandomPhrase(@Path("quantity") quantity : Int) : Single<PhraseResultEntity>
}
package io.github.yamilmedina.viperapp.translations

import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface TranslationService {

    @GET("single?client=gtx&sl=en&dt=t")
    fun translateTo(@Query("tl") toLanguage: String, @Query("q") text: String): Single<String>
}
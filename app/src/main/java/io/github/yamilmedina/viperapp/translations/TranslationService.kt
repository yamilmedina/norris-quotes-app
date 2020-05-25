package io.github.yamilmedina.viperapp.translations

import retrofit2.http.GET
import retrofit2.http.Query

interface TranslationService {

    @GET("single?client=gtx&sl=en&dt=t")
    suspend fun translateTo(@Query("tl") toLanguage: String, @Query("q") text: String): String
}
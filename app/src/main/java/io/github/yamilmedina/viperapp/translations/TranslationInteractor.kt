package io.github.yamilmedina.viperapp.translations

import io.github.yamilmedina.viperapp.utils.HttpManager
import javax.inject.Inject

class TranslationInteractor @Inject constructor() {
    private val translationService: TranslationService by lazy {
        HttpManager.createRemoteService("https://translate.googleapis.com/translate_a/", TranslationService::class.java)
    }

    suspend fun translateTo(toLanguage: String = "es", text: String): String {
        return translationService.translateTo(toLanguage, text)
    }
}
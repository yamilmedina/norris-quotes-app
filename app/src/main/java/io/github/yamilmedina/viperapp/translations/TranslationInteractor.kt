package io.github.yamilmedina.viperapp.translations

import io.github.yamilmedina.viperapp.utils.HttpManager
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

internal class TranslationInteractor {
    private val translationService: TranslationService by lazy {
        HttpManager.createRemoteService("https://translate.googleapis.com/translate_a/", TranslationService::class.java)
    }

    fun translateTo(toLanguage: String = "es", text: String): Single<String> {
        return translationService.translateTo(toLanguage, text)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
    }
}
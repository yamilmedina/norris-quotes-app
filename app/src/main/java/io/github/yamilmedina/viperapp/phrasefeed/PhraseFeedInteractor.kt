package io.github.yamilmedina.viperapp.phrasefeed

import io.github.yamilmedina.viperapp.data.PhraseResultEntity
import io.github.yamilmedina.viperapp.utils.HttpManager
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

internal class PhraseFeedInteractor {

    private val phraseService: PhraseService by lazy {
        HttpManager.createRemoteService("https://api.icndb.com/jokes/", PhraseService::class.java)
    }

    fun fetchRandomPhrases(quantity: Int = 10): Single<PhraseResultEntity> {
        return phraseService.fetchRandomPhrase(quantity)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
    }

}
package io.github.yamilmedina.viperapp.phrasefeed

import io.github.yamilmedina.viperapp.data.PhraseResultEntity
import io.github.yamilmedina.viperapp.network.HttpManager
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

internal class PhraseFeedInteractor {

    private val phraseService: PhraseService by lazy { HttpManager.createRemoteService(PhraseService::class.java) }

    fun fetchRandomPhrases(quantity: Int = 10): Observable<PhraseResultEntity> {
        return phraseService.fetchRandomPhrase(quantity)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
    }

}
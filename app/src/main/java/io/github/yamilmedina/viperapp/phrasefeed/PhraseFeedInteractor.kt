package io.github.yamilmedina.viperapp.phrasefeed

import io.github.yamilmedina.viperapp.data.PhraseResultEntity
import io.github.yamilmedina.viperapp.utils.HttpManager

internal class PhraseFeedInteractor {

    private val phraseService: PhraseService by lazy {
        HttpManager.createRemoteService("https://api.icndb.com/jokes/", PhraseService::class.java)
    }

    suspend fun fetchRandomPhrases(quantity: Int = 1): PhraseResultEntity {
        return phraseService.fetchRandomPhrase(quantity)
    }

}
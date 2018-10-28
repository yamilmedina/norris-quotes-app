package io.github.yamilmedina.viperapp.phrasefeed

import java.util.*

internal class PhraseFeedPresenter constructor(val view: PhraseFeedActivity) {

    fun generateRandomPhrase() {
        val randomPhrase = UUID.randomUUID().toString()
        view.showRandomPhrase(randomPhrase)
    }

}
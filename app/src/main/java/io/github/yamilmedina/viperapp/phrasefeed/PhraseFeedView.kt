package io.github.yamilmedina.viperapp.phrasefeed

interface PhraseFeedView {

    fun showRandomPhrase(randomPhrase: String)

    fun showLoader()

    fun stopLoader()

}
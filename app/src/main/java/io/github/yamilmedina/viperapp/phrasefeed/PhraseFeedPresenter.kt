package io.github.yamilmedina.viperapp.phrasefeed

import android.text.Html
import android.util.Log
import io.reactivex.disposables.Disposable

internal class PhraseFeedPresenter constructor(val view: PhraseFeedView) {

    private var phraseFeedInteractor = PhraseFeedInteractor()
    private var disposable: Disposable? = null

    fun generateRandomPhrase() {
        disposable = phraseFeedInteractor.fetchRandomPhrases(5).subscribe({
            view.showRandomPhrase(getNormalizedText(it.phrases.shuffled().take(1)[0].joke))
        }, {
            Log.e("ERRORS", "Error: ${it.message}")
        })
    }

    fun disposeCalls() {
        disposable?.dispose()
    }

    private fun getNormalizedText(htmlText: String): String {
        return Html.fromHtml(htmlText, Html.FROM_HTML_MODE_LEGACY).toString()
    }

}
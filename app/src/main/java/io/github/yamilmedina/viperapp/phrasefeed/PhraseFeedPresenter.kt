package io.github.yamilmedina.viperapp.phrasefeed

import android.text.Html
import android.util.Log
import io.reactivex.disposables.Disposable
import javax.inject.Inject

internal class PhraseFeedPresenter @Inject constructor(
        private val phraseFeedInteractor: PhraseFeedInteractor) {

    private var disposable: Disposable? = null
    private lateinit var view: PhraseFeedView
    private val phraseFeedRouter: PhraseFeedRouter by lazy { PhraseFeedRouter(view as PhraseFeedActivity) }

    fun generateRandomPhrase() {
        disposable = phraseFeedInteractor.fetchRandomPhrases(5).subscribe({
            view.showRandomPhrase(getNormalizedText(it.phrases.shuffled().take(1)[0].joke))
        }, {
            Log.e("ERRORS", "Error: ${it.message}")
        })
    }

    fun goToPhraseTranslation(text: String) {
        phraseFeedRouter.goToPhrasesScreen(text)
    }

    fun disposeCalls() {
        disposable?.dispose()
    }

    private fun getNormalizedText(htmlText: String): String {
        return Html.fromHtml(htmlText, Html.FROM_HTML_MODE_LEGACY).toString()
    }

    fun setView(view: PhraseFeedView) {
        this.view = view
    }

}
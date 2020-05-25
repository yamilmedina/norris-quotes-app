package io.github.yamilmedina.viperapp.phrasefeed

import android.text.Html
import android.util.Log
import io.github.yamilmedina.viperapp.favorites.FavoritesInteractor
import io.reactivex.disposables.Disposable
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

internal class PhraseFeedPresenter @Inject constructor(
        private val phraseFeedInteractor: PhraseFeedInteractor,
        private val favoritesInteractor: FavoritesInteractor) {

    private var disposable: Disposable? = null
    private lateinit var view: PhraseFeedView

    fun generateRandomPhrase() {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                view.showLoader()
                val phrasesResult = phraseFeedInteractor.fetchRandomPhrases(5)
                withContext(Dispatchers.Main) {
                    view.showRandomPhrase(getNormalizedText(phrasesResult.phrases.shuffled().take(1)[0].joke))
                }
            } catch (e: Exception) {
                Log.e("PhraseFeedPresenter", "Error: ${e.message}")
            } finally {
                view.stopLoader()
            }
        }
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

    fun saveFavorite(favoriteQuote: String) {
        favoritesInteractor.saveFavoriteQuote(favoriteQuote)
    }

}
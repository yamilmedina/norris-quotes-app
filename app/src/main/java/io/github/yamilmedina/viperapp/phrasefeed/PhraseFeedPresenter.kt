package io.github.yamilmedina.viperapp.phrasefeed

import android.util.Log
import io.github.yamilmedina.viperapp.favorites.FavoritesInteractor
import io.github.yamilmedina.viperapp.utils.CoroutineContextProvider
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

internal class PhraseFeedPresenter @Inject constructor(
        private val phraseFeedInteractor: PhraseFeedInteractor,
        private val favoritesInteractor: FavoritesInteractor,
        private val contextProvider: CoroutineContextProvider) {

    private var jobs: MutableSet<Job>? = mutableSetOf()
    private lateinit var view: PhraseFeedView

    fun generateRandomPhrase() {
        val job = CoroutineScope(contextProvider.io).launch {
            try {
                view.showLoader()
                val phrasesResult = phraseFeedInteractor.fetchRandomPhrases()
                withContext(contextProvider.main) {
                    view.showRandomPhrase(phrasesResult.phrases[0].joke)
                }
            } catch (e: Exception) {
                Log.e("PhraseFeedPresenter", "Error: ${e.message}")
            } finally {
                view.stopLoader()
            }
        }
        jobs?.add(job)
    }

    fun disposeCalls() {
        jobs?.forEach {
            it.cancel()
        }
    }

    fun setView(view: PhraseFeedView) {
        this.view = view
    }

    fun saveFavorite(favoriteQuote: String) {
        favoritesInteractor.saveFavoriteQuote(favoriteQuote)
    }

}
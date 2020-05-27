package io.github.yamilmedina.viperapp.translations

import android.util.Log
import io.github.yamilmedina.viperapp.utils.CoroutineContextProvider
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

internal class TranslationPresenter @Inject constructor(
        private val translationInteractor: TranslationInteractor,
        private val contextProvider: CoroutineContextProvider) {

    private var jobs: MutableSet<Job>? = mutableSetOf()
    private lateinit var view: TranslationView

    fun translateTo(to: String, text: String) {
        val job = CoroutineScope(contextProvider.io).launch {
            try {
                val translated = translationInteractor
                        .translateTo("es",
                                text.replace("\"", "")
                                        .replace("'", ""))
                withContext(contextProvider.main) {
                    view.showTranslatedText(translated.split("\"")[1])
                }
            } catch (e: Exception) {
                Log.e("TranslationPresenter", "Error: ${e.message}")
            }
        }
        jobs?.add(job)
    }

    fun setView(view: TranslationView) {
        this.view = view
    }

    fun disposeCalls() {
        jobs?.forEach {
            it.cancel()
        }
    }

}

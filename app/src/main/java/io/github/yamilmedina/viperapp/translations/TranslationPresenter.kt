package io.github.yamilmedina.viperapp.translations

import android.util.Log
import kotlinx.coroutines.*
import javax.inject.Inject

internal class TranslationPresenter @Inject constructor(
        private val translationInteractor: TranslationInteractor) {

    private var jobs: MutableSet<Job>? = mutableSetOf()
    private lateinit var view: TranslationView

    fun translateTo(to: String, text: String) {
        val job = CoroutineScope(Dispatchers.IO).launch {
            try {
                val translated = translationInteractor.translateTo("es", text)
                withContext(Dispatchers.Main) {
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

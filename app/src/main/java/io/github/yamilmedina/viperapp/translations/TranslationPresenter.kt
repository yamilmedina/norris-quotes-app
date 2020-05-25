package io.github.yamilmedina.viperapp.translations

import android.util.Log
import io.reactivex.disposables.Disposable
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

internal class TranslationPresenter @Inject constructor(
        private val translationInteractor: TranslationInteractor) {

    private var disposable: Disposable? = null
    private lateinit var view: TranslationView

    fun translateTo(to: String, text: String) = CoroutineScope(Dispatchers.IO).launch {
        try {
            val translated = translationInteractor.translateTo("es", text)
            withContext(Dispatchers.Main) {
                view.showTranslatedText(translated.split("\"")[1])
            }
        } catch (e: Exception) {
            Log.e("TranslationPresenter", "Error: ${e.message}")
        }
    }

    fun setView(view: TranslationView) {
        this.view = view
    }

}

package io.github.yamilmedina.viperapp.translations

import android.util.Log
import io.reactivex.disposables.Disposable
import javax.inject.Inject

internal class TranslationPresenter @Inject constructor(
        private val translationInteractor: TranslationInteractor) {

    private var disposable: Disposable? = null
    private lateinit var view: TranslationView

    fun translateTo(to: String, text: String) {
        disposable = translationInteractor.translateTo("es", text).subscribe({
            view.showTranslatedText(it?.split("\"")!![1])
        }, {
            Log.e("ERROR", "Error: ${it.message}")
        })
    }

    fun setView(view: TranslationView) {
        this.view = view
    }

}

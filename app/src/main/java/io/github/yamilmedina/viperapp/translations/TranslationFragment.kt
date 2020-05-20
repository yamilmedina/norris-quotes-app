package io.github.yamilmedina.viperapp.translations

import android.os.Bundle
import androidx.fragment.app.Fragment
import io.github.yamilmedina.viperapp.R
import io.github.yamilmedina.viperapp.utils.appComponent
import kotlinx.android.synthetic.main.translations_fragment.*
import javax.inject.Inject

class TranslationFragment : TranslationView, Fragment(R.layout.translations_fragment) {

    @Inject
    internal lateinit var presenter: TranslationPresenter

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        appComponent().inject(this)
        presenter.setView(this)

        arguments?.let {
            val args = TranslationFragmentArgs.fromBundle(it)
            presenter.translateTo("es", args.originalQuote)
        }
    }

    override fun showTranslatedText(text: String) {
        translatedText.text = text
    }

}
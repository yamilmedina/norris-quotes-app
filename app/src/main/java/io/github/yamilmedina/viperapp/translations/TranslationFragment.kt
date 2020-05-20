package io.github.yamilmedina.viperapp.translations

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import io.github.yamilmedina.viperapp.R
import io.github.yamilmedina.viperapp.utils.PHRASE_INTENT_EXTRA
import io.github.yamilmedina.viperapp.utils.appComponent
import kotlinx.android.synthetic.main.translations_fragment.*
import javax.inject.Inject

class TranslationFragment : TranslationView, Fragment() {

    @Inject
    internal lateinit var presenter: TranslationPresenter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.translations_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        //val originalPhrase = savedInstanceState?.getStringExtra(PHRASE_INTENT_EXTRA)
        //presenter.translateTo("es", "nothing")
    }

    override fun showTranslatedText(text: String) {
        translatedText.text = "translation"
    }

}
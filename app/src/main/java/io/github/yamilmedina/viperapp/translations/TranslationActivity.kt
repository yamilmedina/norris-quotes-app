package io.github.yamilmedina.viperapp.translations

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import io.github.yamilmedina.viperapp.R
import io.github.yamilmedina.viperapp.utils.PHRASE_INTENT_EXTRA
import io.github.yamilmedina.viperapp.utils.appComponent
import kotlinx.android.synthetic.main.translations_activity.*
import javax.inject.Inject

class TranslationActivity : TranslationView, AppCompatActivity() {

    @Inject
    internal lateinit var presenter: TranslationPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.translations_activity)

        appComponent().inject(this)

        presenter.setView(this)

        val originalPhrase = intent?.getStringExtra(PHRASE_INTENT_EXTRA)
        presenter.translateTo("es", originalPhrase.orEmpty())
    }

    override fun showTranslatedText(text: String) {
        translatedText.text = text
    }

}
package io.github.yamilmedina.viperapp.translations

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import io.github.yamilmedina.viperapp.R
import io.github.yamilmedina.viperapp.utils.PHRASE_INTENT_EXTRA
import io.github.yamilmedina.viperapp.utils.appComponent
import kotlinx.android.synthetic.main.translations_activity.*

class TranslationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.translations_activity)

        appComponent().inject(this)

        val originalPhrase = intent?.getStringExtra(PHRASE_INTENT_EXTRA)
        translatedText.text = originalPhrase
    }

}
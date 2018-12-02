package io.github.yamilmedina.viperapp.phrasefeed

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import io.github.yamilmedina.viperapp.R
import io.github.yamilmedina.viperapp.utils.appComponent
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class PhraseFeedActivity : PhraseFeedView, AppCompatActivity() {
    @Inject
    internal lateinit var presenter: PhraseFeedPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        appComponent().inject(this)

        buttonNewPhrase.setOnClickListener {
            presenter.generateRandomPhrase()
        }

        buttonTranslate.setOnClickListener {
            presenter.goToPhraseTranslation(textViewPhraseDisplay.text.toString())
        }

        presenter.setView(this)
    }

    override fun showRandomPhrase(randomPhrase: String) {
        textViewPhraseDisplay.text = randomPhrase
    }

    override fun onStop() {
        super.onStop()
        presenter.disposeCalls()
    }

}

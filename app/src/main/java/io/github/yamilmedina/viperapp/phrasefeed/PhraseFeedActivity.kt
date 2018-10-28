package io.github.yamilmedina.viperapp.phrasefeed

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import io.github.yamilmedina.viperapp.R
import kotlinx.android.synthetic.main.activity_main.*

class PhraseFeedActivity : PhraseFeedInterface, AppCompatActivity() {

    private val presenter: PhraseFeedPresenter = PhraseFeedPresenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonNewPhrase.setOnClickListener {
            presenter.generateRandomPhrase()
        }
    }

    override fun showRandomPhrase(randomPhrase: String) {
        textViewPhraseDisplay.text = randomPhrase
    }

}

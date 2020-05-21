package io.github.yamilmedina.viperapp.phrasefeed

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.google.android.material.snackbar.Snackbar
import io.github.yamilmedina.viperapp.R
import io.github.yamilmedina.viperapp.utils.appComponent
import kotlinx.android.synthetic.main.phrase_fragment.*
import javax.inject.Inject


class PhraseFeedFragment : PhraseFeedView, Fragment(R.layout.phrase_fragment) {

    @Inject
    internal lateinit var presenter: PhraseFeedPresenter

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        appComponent().inject(this)
        presenter.setView(this)

        presenter.generateRandomPhrase()

        buttonTranslate.setOnClickListener {
            view?.let {
                val actions = PhraseFeedFragmentDirections.actionPhraseFeedFragmentToTranslationFragment()
                actions.originalQuote = textViewPhraseDisplay.text.toString()
                Navigation.findNavController(it).navigate(actions)
            }
        }

        textViewPhraseDisplay.setOnLongClickListener {
            presenter.saveFavorite(textViewPhraseDisplay.text.toString())
            Snackbar.make(it, "Liked quote saved!", Snackbar.LENGTH_LONG).show()
            return@setOnLongClickListener true
        }
    }

    override fun showRandomPhrase(randomPhrase: String) {
        textViewPhraseDisplay.text = randomPhrase
    }

    override fun showLoader() {
        phraseContainerGroup.showShimmer(true)
    }

    override fun stopLoader() {
        phraseContainerGroup.stopShimmer()
        phraseContainerGroup.hideShimmer()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.disposeCalls()
    }
}
package io.github.yamilmedina.viperapp.phrasefeed

import android.animation.Animator
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import io.github.yamilmedina.viperapp.R
import io.github.yamilmedina.viperapp.utils.appComponent
import kotlinx.android.synthetic.main.phrase_fragment.*
import javax.inject.Inject


class PhraseFeedFragment : PhraseFeedView, Fragment() {

    @Inject
    internal lateinit var presenter: PhraseFeedPresenter

    private lateinit var spruceAnimator: Animator

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.phrase_fragment, container, false)
    }

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
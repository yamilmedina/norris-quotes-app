package io.github.yamilmedina.viperapp.phrasefeed

import com.nhaarman.mockito_kotlin.any
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import com.nhaarman.mockito_kotlin.whenever
import org.junit.Before
import org.junit.Test

class PhraseFeedPresenterTest {

    private lateinit var presenter : PhraseFeedPresenter
    private lateinit var view : PhraseFeedInterface
    private val interactor = mock<PhraseFeedInteractor> {  }

    @Before
    fun setUp() {
        view = mock { }
        presenter = PhraseFeedPresenter(view)
    }

    @Test
    fun shouldSetTextWhenFetchPhrases() {
        whenever(interactor.fetchRandomPhrases(any())).thenReturn(mock {  })

        presenter.generateRandomPhrase()

        verify(view).showRandomPhrase(any())
    }
}


package io.github.yamilmedina.viperapp.phrasefeed


import com.nhaarman.mockitokotlin2.*
import io.github.yamilmedina.viperapp.data.PhraseEntity
import io.github.yamilmedina.viperapp.data.PhraseResultEntity
import io.github.yamilmedina.viperapp.favorites.FavoritesInteractor
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runBlockingTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Test


@ExperimentalCoroutinesApi
class PhraseFeedPresenterTest {

    private lateinit var presenter: PhraseFeedPresenter
    private lateinit var view: PhraseFeedView
    private val interactor = mock<PhraseFeedInteractor> { }
    private val favoritesInteractor = mock<FavoritesInteractor> {}
    private val testCoroutinesDispatcherProvider = TestContextProvider()

    @Before
    fun setUp() {
        view = mock {}
        presenter = PhraseFeedPresenter(interactor, favoritesInteractor, testCoroutinesDispatcherProvider)
        presenter.setView(view)
        Dispatchers.setMain(testCoroutinesDispatcherProvider.testDispatcher)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun shouldSetTextWhenFetchPhrases() = runBlockingTest {
        val phrases = mutableListOf(PhraseEntity(1, "a joke")).toList()
        val phraseResultEntity = PhraseResultEntity("a", phrases)

        interactor.stub {
            onBlocking { fetchRandomPhrases(any()) }.doReturn(phraseResultEntity)
        }

        presenter.generateRandomPhrase()

        verify(view).showLoader()
        verify(view).showRandomPhrase(any())
    }


}


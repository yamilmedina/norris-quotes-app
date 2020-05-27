package io.github.yamilmedina.viperapp.translations

import com.nhaarman.mockitokotlin2.*
import io.github.yamilmedina.viperapp.TestContextProvider
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runBlockingTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Test

@ExperimentalCoroutinesApi
class TranslationPresenterTest {

    private val testContextProvider: TestContextProvider = TestContextProvider()
    private val translationInteractor: TranslationInteractor = mock { }
    private val view: TranslationView = mock { }
    private lateinit var translationPresenter: TranslationPresenter

    @Before
    fun setUp() {
        translationPresenter = TranslationPresenter(translationInteractor, testContextProvider)
        translationPresenter.setView(view)
        Dispatchers.setMain(testContextProvider.testDispatcher)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun `Ensure a Joke is translated to spanish`() = runBlockingTest {
        //given
        val translatedText = "esta es una \"traducción\""
        translationInteractor.stub {
            onBlocking { translateTo(any(), any()) }.doReturn(translatedText)
        }

        //when
        translationPresenter.translateTo("es", "some_text")

        //then
        verify(view).showTranslatedText(any())
    }

}


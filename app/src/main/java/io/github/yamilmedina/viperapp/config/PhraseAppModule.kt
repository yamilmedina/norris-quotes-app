package io.github.yamilmedina.viperapp.config

import android.content.Context
import dagger.Module
import dagger.Provides
import io.github.yamilmedina.viperapp.phrasefeed.PhraseFeedInteractor
import io.github.yamilmedina.viperapp.phrasefeed.PhraseFeedPresenter
import io.github.yamilmedina.viperapp.translations.TranslationInteractor
import io.github.yamilmedina.viperapp.translations.TranslationPresenter
import javax.inject.Singleton

@Module
class PhraseAppModule(val context: Context) {

    @Provides
    @Singleton
    fun provideContext() = context

    @Provides
    @Singleton
    internal fun getPhraseFeedInteractor(): PhraseFeedInteractor = PhraseFeedInteractor()

    @Provides
    @Singleton
    internal fun getPhraseFeedPresenter(phraseFeedInteractor: PhraseFeedInteractor): PhraseFeedPresenter = PhraseFeedPresenter(phraseFeedInteractor)

    @Provides
    @Singleton
    internal fun getTranslationPresenter(translationInteractor: TranslationInteractor) =  TranslationPresenter(translationInteractor)

    @Provides
    @Singleton
    internal fun getTranslationsInteractor() = TranslationInteractor()

}
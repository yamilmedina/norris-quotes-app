package io.github.yamilmedina.viperapp.config

import dagger.Component
import io.github.yamilmedina.viperapp.phrasefeed.PhraseFeedFragment
import io.github.yamilmedina.viperapp.translations.TranslationFragment
import javax.inject.Singleton

@Singleton
@Component(modules = [PhraseAppModule::class])
interface PhraseAppComponent {

    fun inject(phraseFeedFragment: PhraseFeedFragment)
    fun inject(translationFragment: TranslationFragment)

}
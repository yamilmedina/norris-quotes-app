package io.github.yamilmedina.viperapp.config

import dagger.Component
import io.github.yamilmedina.viperapp.phrasefeed.PhraseFeedActivity
import io.github.yamilmedina.viperapp.translations.TranslationActivity
import javax.inject.Singleton

@Singleton
@Component(modules = [PhraseAppModule::class])
interface PhraseAppComponent {

    fun inject(phraseFeedActivity: PhraseFeedActivity)
    fun inject(translationActivity: TranslationActivity)

}
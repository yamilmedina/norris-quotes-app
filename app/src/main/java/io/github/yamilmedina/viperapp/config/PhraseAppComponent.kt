package io.github.yamilmedina.viperapp.config

import dagger.Component
import io.github.yamilmedina.viperapp.phrasefeed.PhraseFeedActivity
import javax.inject.Singleton

@Singleton
@Component(modules = [PhraseAppModule::class])
interface PhraseAppComponent {

    fun inject(phraseFeedActivity: PhraseFeedActivity)

}
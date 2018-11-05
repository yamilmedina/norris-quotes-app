package io.github.yamilmedina.viperapp.config

import android.content.Context
import dagger.Module
import dagger.Provides
import io.github.yamilmedina.viperapp.phrasefeed.PhraseFeedInteractor
import javax.inject.Singleton

@Module
class PhraseAppModule(val context: Context) {

    @Provides
    @Singleton
    fun provideContext() = context

    @Provides
    @Singleton
    private fun getPhraseFeedInteractor(): PhraseFeedInteractor {
        return PhraseFeedInteractor()
    }
}
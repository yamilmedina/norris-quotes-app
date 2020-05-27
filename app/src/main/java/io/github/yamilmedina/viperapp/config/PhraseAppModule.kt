package io.github.yamilmedina.viperapp.config

import android.content.Context
import dagger.Module
import dagger.Provides
import io.github.yamilmedina.viperapp.phrasefeed.PhraseFeedInteractor
import io.github.yamilmedina.viperapp.utils.CoroutineContextProvider
import io.github.yamilmedina.viperapp.utils.DefaultCoroutineContextProvider
import javax.inject.Singleton

@Module
class PhraseAppModule(private val context: Context) {

    @Provides
    @Singleton
    fun provideContext() = context

    @Provides
    @Singleton
    internal fun getPhraseFeedInteractor(): PhraseFeedInteractor = PhraseFeedInteractor()

    @Provides
    @Singleton
    internal fun getDefaultCoroutinesProvider(): CoroutineContextProvider = DefaultCoroutineContextProvider()


}
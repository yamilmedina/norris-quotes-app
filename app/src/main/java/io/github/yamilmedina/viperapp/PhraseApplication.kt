package io.github.yamilmedina.viperapp

import android.app.Application
import io.github.yamilmedina.viperapp.config.DaggerPhraseAppComponent
import io.github.yamilmedina.viperapp.config.PhraseAppComponent
import io.github.yamilmedina.viperapp.config.PhraseAppModule

class PhraseApplication : Application() {

    lateinit var phraseAppComponent: PhraseAppComponent

    override fun onCreate() {
        super.onCreate()
        phraseAppComponent = initDagger(this)
    }

    private fun initDagger(app: PhraseApplication): PhraseAppComponent =
            DaggerPhraseAppComponent.builder()
                    .phraseAppModule(PhraseAppModule(app))
                    .build()

}

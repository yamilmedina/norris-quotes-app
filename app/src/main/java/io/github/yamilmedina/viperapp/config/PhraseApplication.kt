package io.github.yamilmedina.viperapp.config

import android.app.Application

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

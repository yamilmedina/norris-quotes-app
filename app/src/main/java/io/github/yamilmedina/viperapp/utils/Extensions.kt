package io.github.yamilmedina.viperapp.utils

import android.app.Activity
import io.github.yamilmedina.viperapp.PhraseApplication
import io.github.yamilmedina.viperapp.config.PhraseAppComponent

fun Activity.appComponent(): PhraseAppComponent {
    return (application as PhraseApplication).phraseAppComponent
}
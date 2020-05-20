package io.github.yamilmedina.viperapp.utils

import android.app.Activity
import androidx.fragment.app.Fragment
import io.github.yamilmedina.viperapp.PhraseApplication
import io.github.yamilmedina.viperapp.config.PhraseAppComponent

fun Activity.appComponent(): PhraseAppComponent {
    return (application as PhraseApplication).phraseAppComponent
}

fun Fragment.appComponent(): PhraseAppComponent {
    return (activity?.application as PhraseApplication).phraseAppComponent
}
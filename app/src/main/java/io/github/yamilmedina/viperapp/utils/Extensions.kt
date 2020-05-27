package io.github.yamilmedina.viperapp.utils

import android.app.Activity
import android.text.Html
import androidx.fragment.app.Fragment
import io.github.yamilmedina.viperapp.PhraseApplication
import io.github.yamilmedina.viperapp.config.PhraseAppComponent

fun Activity.appComponent(): PhraseAppComponent {
    return (application as PhraseApplication).phraseAppComponent
}

fun Fragment.appComponent(): PhraseAppComponent {
    return (activity?.application as PhraseApplication).phraseAppComponent
}

fun String.convertFromHtml(): String {
    return Html.fromHtml(this, Html.FROM_HTML_MODE_LEGACY).toString()
}
package io.github.yamilmedina.viperapp.phrasefeed

import android.content.Intent
import io.github.yamilmedina.viperapp.MainActivity
import io.github.yamilmedina.viperapp.translations.TranslationFragment
import io.github.yamilmedina.viperapp.utils.PHRASE_INTENT_EXTRA

class PhraseFeedRouter(var activity: MainActivity?) {

    fun goToPhrasesScreen(originalPhrase: String) {
        val intent = Intent(activity, TranslationFragment::class.java)
        intent.putExtra(PHRASE_INTENT_EXTRA, originalPhrase)
        activity?.startActivity(intent)
    }
}
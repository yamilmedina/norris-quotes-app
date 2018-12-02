package io.github.yamilmedina.viperapp.phrasefeed

import android.content.Intent
import io.github.yamilmedina.viperapp.translations.TranslationActivity
import io.github.yamilmedina.viperapp.utils.PHRASE_INTENT_EXTRA

class PhraseFeedRouter(var activity: PhraseFeedActivity?) {

    fun goToPhrasesScreen(originalPhrase: String) {
        val intent = Intent(activity, TranslationActivity::class.java)
        intent.putExtra(PHRASE_INTENT_EXTRA, originalPhrase)
        activity?.startActivity(intent)
    }
}
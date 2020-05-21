package io.github.yamilmedina.viperapp.favorites

import android.content.Context
import javax.inject.Inject

const val QUOTES_KEY = "QUOTES"
const val DB_PREF = "io.github.yamilmedina.favoritequotes"

class FavoritesInteractor @Inject constructor(private val context: Context) {

    fun getFavoriteQuotes(): List<String> {
        val sharedPreferences = context.getSharedPreferences(DB_PREF, Context.MODE_PRIVATE)
        val quotes = sharedPreferences.getStringSet(QUOTES_KEY, null)
        return quotes?.toList()!!
    }

    fun saveFavoriteQuote(favoriteQuote: String) {
        val sharedPreferences = context.getSharedPreferences(DB_PREF, Context.MODE_PRIVATE)
        val quotes = sharedPreferences.getStringSet(QUOTES_KEY, null)
        quotes?.add(favoriteQuote)

        val editor = sharedPreferences.edit()
        editor.remove(QUOTES_KEY)
        editor.putStringSet(QUOTES_KEY, quotes)

        editor.apply()
    }
}
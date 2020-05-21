package io.github.yamilmedina.viperapp.favorites

import android.os.Bundle
import androidx.fragment.app.Fragment
import io.github.yamilmedina.viperapp.R
import io.github.yamilmedina.viperapp.utils.appComponent
import kotlinx.android.synthetic.main.favorites_fragment.*
import javax.inject.Inject

class FavoritesFragment : FavoritesView, Fragment(R.layout.favorites_fragment) {

    @Inject
    lateinit var favoritesInteractor: FavoritesInteractor
    lateinit var adapter: FavoritesAdapter

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        appComponent().inject(this)

        val quotes: List<String> = favoritesInteractor.getFavoriteQuotes()
        adapter = FavoritesAdapter(quotes)
        favoritesList.adapter = adapter
    }
}
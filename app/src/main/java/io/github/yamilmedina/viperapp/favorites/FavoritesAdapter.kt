package io.github.yamilmedina.viperapp.favorites

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import io.github.yamilmedina.viperapp.R

class FavoritesAdapter(private var list: List<String> = mutableListOf()) : RecyclerView.Adapter<FavoriteViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteViewHolder {
        return FavoriteViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.favorite_list_item, parent, false))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: FavoriteViewHolder, position: Int) {
        holder.bindItem(list[position])
    }

    fun setFavorites(favorites: List<String>) {
        list = favorites
        notifyDataSetChanged()
    }

}

class FavoriteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val textView: TextView = itemView.findViewById(R.id.quoteFaved)

    fun bindItem(quote: String) {
        textView.text = quote
    }
}
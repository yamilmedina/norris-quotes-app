package io.github.yamilmedina.viperapp.data

import com.google.gson.annotations.SerializedName

data class PhraseEntity(@SerializedName("id") var id: Int, @SerializedName("joke") var joke: String)


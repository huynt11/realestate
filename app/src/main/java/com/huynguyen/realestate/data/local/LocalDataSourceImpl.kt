package com.huynguyen.realestate.data.local

import android.content.SharedPreferences
import javax.inject.Inject

class LocalDataSourceImpl @Inject constructor(
    private val sharedPreferences: SharedPreferences,
) : LocalDataSource {

    override fun saveFavorite(id: String) {
        var favorites = sharedPreferences.getString(SHARED_PREF_FAVORITE, "")
        favorites += "-$id"
        sharedPreferences.edit()
            .putString(SHARED_PREF_FAVORITE, favorites)
            .apply()
    }

    override fun removeFavorite(id: String) {
        var favorites = sharedPreferences.getString(SHARED_PREF_FAVORITE, "")
        favorites = favorites!!.replace("-$id", "")
        sharedPreferences.edit()
            .putString(SHARED_PREF_FAVORITE, favorites)
            .apply()
    }

    override fun getFavorites(): List<String> {
        val favorites = sharedPreferences.getString(SHARED_PREF_FAVORITE, "")
        return favorites!!.split("-")
    }

    companion object {
        const val SHARED_PREF_FAVORITE = "com.huynguyen.realestate.favorite"
    }


}
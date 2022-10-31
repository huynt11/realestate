package com.huynguyen.realestate.data.local

interface LocalDataSource {

    fun saveFavorite(id: String)

    fun removeFavorite(id: String)

    fun getFavorites(): List<String>
}
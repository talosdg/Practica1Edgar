package com.talos.placesdb.application

import android.app.Application
import com.talos.placesdb.data.PlaceRepository
import com.talos.placesdb.data.db.GameDatabase

class PlacesDBApp: Application() {
    private val database by lazy{
        GameDatabase.getDatabase(this@PlacesDBApp)
    }

    val repository by lazy{
        PlaceRepository(database.gameDao())
    }
}
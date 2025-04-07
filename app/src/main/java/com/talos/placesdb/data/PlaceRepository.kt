package com.talos.placesdb.data

import com.talos.placesdb.data.db.GameDao
import com.talos.placesdb.data.db.model.GameEntity

class PlaceRepository(
    private val gameDao: GameDao
) {

    suspend fun insertGame(game: GameEntity){
        gameDao.insertGame(game)
    }

    suspend fun getAllGames(): MutableList<GameEntity> =
        gameDao.getAllGames()

    suspend fun updateGame(game: GameEntity){
        gameDao.updateGame(game)
    }

    suspend fun deleteGame(game: GameEntity){
        gameDao.deleteGame(game)
    }

}
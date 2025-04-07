package com.talos.placesdb.data.db.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.talos.placesdb.util.Constants

@Entity(tableName = Constants.DATABASE_GAME_TABLE)
data class GameEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "game_id")
    var id: Long = 0,
    @ColumnInfo(name = "game_title")
    var title: String,
    @ColumnInfo(name = "game_genre") // es el  estado y ya se guarda
    var genre: String,
    @ColumnInfo(name = "game_developer", defaultValue = "unknown")
    var developer: String
)

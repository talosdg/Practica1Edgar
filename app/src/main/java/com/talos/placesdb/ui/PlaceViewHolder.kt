package com.talos.placesdb

import androidx.recyclerview.widget.RecyclerView
import com.talos.placesdb.data.db.model.GameEntity
import com.talos.practica1edgar.R
import com.talos.practica1edgar.databinding.GameElementBinding


class PlaceViewHolder(
    private val  binding: GameElementBinding

): RecyclerView.ViewHolder(binding.root) {

    fun bind(game: GameEntity) {

        binding.apply {
            tvTitle.text = game.title
            tvGenre.text = game.genre
            tvDeveloper.text = game.developer

        }

        val location = game.genre  // valor dinámico

        // Asignacion de la imagen
        val resourceId = when (location.lowercase()) {
            "tlaxcala" -> R.drawable.tlaxcala
            "puebla" -> R.drawable.puebla
            "queretaro" -> R.drawable.queretaro
            "morelos" -> R.drawable.morelos
            "hidalgo" -> R.drawable.hidalgo
            "estado de méxico" -> R.drawable.edomex
            else -> R.drawable.mexico
        }

        // Establecer la imagen del estado
        binding.ivIcon.setImageResource(resourceId)
    }
}

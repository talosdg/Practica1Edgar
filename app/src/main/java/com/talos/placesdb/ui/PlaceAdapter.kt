package com.talos.placesdb.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.talos.placesdb.PlaceViewHolder
import com.talos.placesdb.data.db.model.GameEntity
import com.talos.practica1edgar.databinding.GameElementBinding


class PlaceAdapter(
    private val onGameClick: (GameEntity) -> Unit
): RecyclerView.Adapter<PlaceViewHolder>() {

    private var games: List<GameEntity> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlaceViewHolder {
        val binding = GameElementBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PlaceViewHolder(binding)
    }

    override fun getItemCount(): Int = games.size

    override fun onBindViewHolder(holder: PlaceViewHolder, position: Int) {
        val game = games[position]

        holder.bind(game)

        holder.itemView.setOnClickListener {
            //Aquí va el click para cada elemento
            onGameClick(game)
        }
    }

    //Actualizamos el adapter para los nuevos elementos actualizados
    fun updateList(list: MutableList<GameEntity>){
        games = list
        notifyDataSetChanged()
    }
}
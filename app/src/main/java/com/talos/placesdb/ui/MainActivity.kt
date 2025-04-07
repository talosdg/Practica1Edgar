package com.talos.placesdb.ui

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager

import com.google.android.material.snackbar.Snackbar
import com.talos.placesdb.application.PlacesDBApp
import com.talos.placesdb.data.PlaceRepository
import com.talos.placesdb.data.db.model.GameEntity
import com.talos.practica1edgar.R
import com.talos.practica1edgar.databinding.ActivityMainBinding
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    //Para el listado de juegos a leer en la bd
    private var games: MutableList<GameEntity> = mutableListOf()

    //Para el repositorio
    private lateinit var repository: PlaceRepository

    //Para el adapter del recycler view
    private lateinit var gameAdapter: PlaceAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        repository = (application as PlacesDBApp).repository

        gameAdapter = PlaceAdapter { selectedGame ->

            val dialog = PlaceDialog(
                newGame = false,
                game = selectedGame,
                updateUI = {
                    updateUI()
                },
                message = { text ->
                    message(text)
                }
            )

            dialog.show(supportFragmentManager, "dialog2")


        }

        binding.apply {
            rvGames.layoutManager = LinearLayoutManager(this@MainActivity)
            rvGames.adapter = gameAdapter
        }


        updateUI()
    }

    private fun updateUI() {
        lifecycleScope.launch {
            //Obtenemos todos los juegos
            games = repository.getAllGames()

            binding.tvSinRegistros.visibility =
                if (games.isNotEmpty()) View.INVISIBLE else View.VISIBLE

            gameAdapter.updateList(games)
        }
    }

    fun click(view: View) {
        /*val game = GameEntity(
            title = "Mario Kart 8",
            genre = "Carreras",
            developer = "Nintendo"
        )
        lifecycleScope.launch {
            repository.insertGame(game)
        }
        updateUI()*/

        //Mostramos el diálogo
        val dialog = PlaceDialog(
            updateUI = {
                updateUI()
            },
            message = { text ->
                message(text)
            }
        )
        dialog.show(supportFragmentManager, "dialog1")
    }

    /*private fun updateUI(){
        lifecycleScope.launch {
            //Obtenemos todos los juegos
            games = repository.getAllGames()

            binding.tvSinRegistros.visibility =
                if (games.isNotEmpty()) View.INVISIBLE else View.VISIBLE

        }
    }*/

    /*fun click(view: View){
        val game = GameEntity(
            title = "Mario Kart 8",
            genre = "Carreras",
            developer = "Nintendo"
        )

        lifecycleScope.launch {
            repository.insertGame(game)
        }
    }*/

    private fun message(text: String) {
        /*Toast.makeText(
            this,
            text,
            Toast.LENGTH_SHORT
        )
            .show()*/
        Snackbar.make(binding.main, text, Snackbar.LENGTH_SHORT)
            .setTextColor(getColor(R.color.white))
            .setBackgroundTint(getColor(R.color.my_red)) //#9E1734
            //.setBackgroundTint(Color.parseColor("#9E1734"))
            .show()
    }
}
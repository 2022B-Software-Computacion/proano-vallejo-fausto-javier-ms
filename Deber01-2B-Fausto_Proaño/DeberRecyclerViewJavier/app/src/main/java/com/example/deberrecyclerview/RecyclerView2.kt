package com.example.deberrecyclerview

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatDelegate
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.deberrecyclerview.adapter.FuentesAdapter
import com.google.android.material.bottomnavigation.BottomNavigationView

@Suppress("DEPRECATION")
class RecyclerView2 : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view2)
        initRecyclerView()

        //Llamar al icono de correos para mostrar el fragmento
        val bottomNavigation = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        val menu = bottomNavigation.menu
        val itemInicio = menu.findItem(R.id.menu_correo)
        itemInicio.setOnMenuItemClickListener {
            startActivity(Intent(this, RecyclerView1::class.java))
            true
        }
    }

    private fun initRecyclerView() {
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerDocumentos)
        recyclerView.layoutManager = LinearLayoutManager(this)
        val decoration = DividerItemDecoration(this, LinearLayoutManager(this).orientation)

        recyclerView.adapter = FuentesAdapter(FuentesProvider.listaFuentes) { fuentes ->
            onItemSelected(fuentes)
        }
        recyclerView.addItemDecoration(decoration)
    }

    fun onItemSelected(fuentes: Fuentes) {
        Toast.makeText(
            this,
            fuentes.modificadorNombre,
            Toast.LENGTH_SHORT
        ).show()
    }

}


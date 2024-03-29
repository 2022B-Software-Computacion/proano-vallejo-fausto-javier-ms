package com.example.deberrecyclerview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatDelegate
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.deberrecyclerview.adapter.CorreoAdapter
import com.example.deberrecyclerview.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

@Suppress("DEPRECATION")
class RecyclerView1 : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true)
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initRecyclerView()

        //Llamar al icono de fuentes para mostrar el fragmento
        val bottomNavigation = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        val menu = bottomNavigation.menu
        val itemDocumento = menu.findItem(R.id.menu_fuente)
        itemDocumento.setOnMenuItemClickListener {
            startActivity(Intent(this, RecyclerView2::class.java))
            true
        }
    }

    private fun initRecyclerView() {
        val manager = LinearLayoutManager(this)
        val decoration = DividerItemDecoration(this, manager.orientation)
        binding.recyclerArchivoPDF.layoutManager = manager
        binding.recyclerArchivoPDF.adapter = CorreoAdapter(
            CorreoProvider.listaCorreos
        ) { correo -> onItemSelected(correo) }
        binding.recyclerArchivoPDF.addItemDecoration(decoration)
    }

    fun onItemSelected(correo: Correo) {
        Toast.makeText(
            this,
            "Emitido por: " + correo.nombreEmisor,
            Toast.LENGTH_SHORT
        ).show()
    }

}
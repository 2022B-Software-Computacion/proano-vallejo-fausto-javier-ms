package com.example.deberrecyclerview.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.deberrecyclerview.Fuentes
import com.example.deberrecyclerview.R
import com.example.deberrecyclerview.databinding.ItemFuenteBinding
import com.squareup.picasso.Picasso

class FuentesViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    val binding = ItemFuenteBinding.bind(view)

    fun render(documentoModelo: Fuentes, onClickListener: (Fuentes) -> Unit) {
        binding.textModificador.text = documentoModelo.modificadorNombre
        binding.textTituloDoc.text = documentoModelo.tituloDoc
        binding.textVistas.text = documentoModelo.vistas.toString()
        Picasso.get().load(documentoModelo.srcImagen).error(R.mipmap.ic_launcher_round)
            .into(binding.imageView)
        Picasso.get().load(documentoModelo.srcImagen2).error(R.mipmap.ic_launcher_round)
            .into(binding.imageView2)
    }
}
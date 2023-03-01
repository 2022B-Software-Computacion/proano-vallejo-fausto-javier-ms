package com.example.deberrecyclerview.adapter

import android.annotation.SuppressLint
import  android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.deberrecyclerview.Correo
import com.example.deberrecyclerview.databinding.ItemCorreoBinding

class CorreoViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val binding = ItemCorreoBinding.bind(view)

    @SuppressLint("ResourceAsColor")
    fun render(correoModel: Correo, onClickListener: (Correo) -> Unit) {
        binding.textNombreEmisor.text = correoModel.nombreEmisor
        binding.textContenido.text = correoModel.contenido
        binding.textDescripcion.text = correoModel.descripcion
        binding.tvLogo.text = correoModel.logo
        itemView.setOnClickListener {
            onClickListener(correoModel)
        }

    }
}
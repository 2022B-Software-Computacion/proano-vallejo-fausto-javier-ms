package com.example.deberrecyclerview.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.deberrecyclerview.Correo
import com.example.deberrecyclerview.R

class CorreoAdapter(
    private val archivosPDF: List<Correo>,
    private val onClickListener: (Correo) -> Unit
) :
    RecyclerView.Adapter<CorreoViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CorreoViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return CorreoViewHolder(
            layoutInflater.inflate(
                R.layout.item_correo,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: CorreoViewHolder, position: Int) {
        val item = archivosPDF[position]
        holder.render(item, onClickListener)

    }

    override fun getItemCount(): Int {
        return archivosPDF.size
    }
}
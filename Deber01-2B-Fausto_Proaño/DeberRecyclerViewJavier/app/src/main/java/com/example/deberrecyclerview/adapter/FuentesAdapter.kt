package com.example.deberrecyclerview.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.deberrecyclerview.Fuentes
import com.example.deberrecyclerview.R

class FuentesAdapter(
    private val documentos: List<Fuentes>,
    private val onClickListener: (Fuentes) -> Unit
) :
    RecyclerView.Adapter<FuentesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FuentesViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return FuentesViewHolder(
            layoutInflater.inflate(
                R.layout.item_fuente,
                parent,
                false
            )
        )
    }


    override fun onBindViewHolder(holder: FuentesViewHolder, position: Int) {
        val item = documentos[position]
        holder.render(item, onClickListener)

    }

    override fun getItemCount(): Int {
        return documentos.size
    }
}
package com.failoc.tercerapracticacalificada.Home

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.failoc.tercerapracticacalificada.Model.Nota
import com.failoc.tercerapracticacalificada.R

class HomeViewHolder (inflater: LayoutInflater, parent: ViewGroup):
    RecyclerView.ViewHolder(inflater.inflate(R.layout.item_nota, parent, false)){


    private var textTitle: TextView? = null
    private var textAutor: TextView? = null
    private var textCategory: TextView? = null
    private var textEditorial: TextView? = null
    private var textDescription: TextView? = null

    init {

        textTitle = itemView.findViewById(R.id.textTitle)
        textAutor = itemView.findViewById(R.id.textAutor)
        textCategory = itemView.findViewById(R.id.textCategoria)
        textEditorial = itemView.findViewById(R.id.textEditorial)
        textDescription = itemView.findViewById(R.id.textDescription)
    }

    fun bind(nota: Nota) {

        textTitle?.text = nota.title
        textAutor?.text = nota.autor
        textCategory?.text = nota.category
        textEditorial?.text = nota.editorial
        textDescription?.text = nota.description
    }
}
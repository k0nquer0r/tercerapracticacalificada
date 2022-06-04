package com.failoc.tercerapracticacalificada.Home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.failoc.tercerapracticacalificada.Model.Nota

class HomeAdapter(val mItemClickListener: ItemClickListener): RecyclerView.Adapter<HomeViewHolder>() {

    private var noteList = emptyList<Nota>()

    fun setNotes(notas: List<Nota>) {
        this.noteList = notas
        this.notifyDataSetChanged()
    }

    override fun getItemCount(): Int = noteList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return HomeViewHolder(inflater, parent)
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        val note: Nota =  noteList[position]
        holder.bind(note)
        holder.itemView.setOnClickListener{
            mItemClickListener.onItemClick(note)
        }
    }

    interface ItemClickListener{
        fun onItemClick(nota: Nota)
    }

}
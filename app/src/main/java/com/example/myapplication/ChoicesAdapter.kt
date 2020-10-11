package com.example.myapplication

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.RadioButton
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_in_list.view.*


class ChoicesAdapter(private val list: List<ChoiceModel>)
    : RecyclerView.Adapter<ChoicesAdapter.MovieViewHolder>(){
    var lastSelectedPosition = -1
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return MovieViewHolder(inflater, parent)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie: ChoiceModel = list[position]
        if (!movie.selected){
            movie.selected = lastSelectedPosition == position
        }
        holder.choice.isChecked = lastSelectedPosition == position
        holder.bind(movie)
    }

    override fun getItemCount(): Int = list.size

    inner class MovieViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
        RecyclerView.ViewHolder(inflater.inflate(R.layout.item_in_list, parent, false)) {

        val choice: RadioButton = itemView.choice
        init {
            itemView.choice.setOnClickListener {
                lastSelectedPosition = adapterPosition
                for ((index,value) in list.withIndex()){
                    if (index != adapterPosition)
                        value.selected = false
                }
                notifyDataSetChanged()
            }
        }
        fun bind(movie: ChoiceModel) {
            itemView.choice.text = movie.choice
            itemView.choice.isChecked = movie.selected
        }
    }

}



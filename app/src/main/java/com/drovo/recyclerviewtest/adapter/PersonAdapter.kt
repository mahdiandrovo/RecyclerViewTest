package com.drovo.recyclerviewtest.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.drovo.recyclerviewtest.R
import com.drovo.recyclerviewtest.interfaces.OnItemClickedListener
import com.drovo.recyclerviewtest.model.Person

class PersonAdapter(
    var personList: List<Person>
): RecyclerView.Adapter<PersonAdapter.PersonViewHolder>() {

    private lateinit var onItemClickedListener: OnItemClickedListener

    fun setOnItemclickedListener(listener: OnItemClickedListener){
        onItemClickedListener = listener
    }

    inner class PersonViewHolder(itemView: View, listener: OnItemClickedListener) : RecyclerView.ViewHolder(itemView) {
        val img: ImageView = itemView.findViewById(R.id.img)
        val txt: TextView = itemView.findViewById(R.id.txt)
        init {
            itemView.setOnClickListener {
                listener.onItemClicked(adapterPosition)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_person_details, parent, false)
        return PersonViewHolder(itemView, onItemClickedListener)
    }

    override fun getItemCount(): Int {
        return personList.size
    }

    override fun onBindViewHolder(holder: PersonViewHolder, position: Int) {
        var currentItem = personList[position]
        holder.img.setImageResource(currentItem.img)
        holder.txt.text = currentItem.txt
    }


}
package com.example.baeza.simplerecyclerkotlin

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

/**
 * Created by baeza on 25.01.2018.
 */

class RecyclerAdapter//constructor to create the RecyclerAdapter
(internal var mPetList: List<Pet>, private val mOnClickListener: ListItemClickListener) : RecyclerView.Adapter<RecyclerAdapter.RecyclerViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {

        val context = parent.context
        val layout = R.layout.item_recycler
        val inflater = LayoutInflater.from(context)

        val view = inflater.inflate(layout, parent, false)

        return RecyclerViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
        //en OnBindViewHolder vamos llenando lo que se vera en pantalla
        val pet = mPetList[position]
        holder.mTextViewLeft.text = pet.name
        holder.mTextViewRight.text = Integer.toString(pet.age)
    }

    override fun getItemCount(): Int {
        //we return the recycler View with the number of items
        //esta es la cantidad de items del recycler view
        return mPetList.size
    }


    inner class RecyclerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
        //en el viewHolder declaramos los items
        var mTextViewLeft: TextView
        var mTextViewRight: TextView

        init {
            mTextViewLeft = itemView.findViewById<View>(R.id.textViewLeft) as TextView
            mTextViewRight = itemView.findViewById<View>(R.id.textViewRight) as TextView
            itemView.setOnClickListener(this)
        }

        override fun onClick(view: View) {
            val clickedPosition = adapterPosition
            mOnClickListener.onListItemClick(clickedPosition)
        }
    }

    //agregando una interfaz para manejar los clicks
    interface ListItemClickListener {
        fun onListItemClick(clickedItemIndex: Int)
    }

}

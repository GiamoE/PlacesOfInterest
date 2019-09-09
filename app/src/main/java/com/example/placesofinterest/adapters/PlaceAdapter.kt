package com.example.placesofinterest.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.placesofinterest.R
import com.example.placesofinterest.dataClasses.Place
import kotlinx.android.synthetic.main.item_place.view.*

class PlaceAdapter(private val places: List<Place>) :
    RecyclerView.Adapter<PlaceAdapter.ViewHolder>() {

    lateinit var context: Context

    // in the layoutinflater you can select which .xml to use (item_place in this case)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context
        return ViewHolder(
            LayoutInflater.from(context).inflate(R.layout.item_place, parent, false)
        )
    }

    // get the size of the array
    override fun getItemCount(): Int {
        return places.size
    }

    // bind the item in the array with the given position / int
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(places[position])
    }

    // this is where you actually fill the layout
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(place : Place) {
            itemView.tvPlace.text = place.name
            itemView.ivPlaces.setImageDrawable(context.getDrawable(place.imageResId))
        }
    }

}

package com.example.placesofinterest.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.placesofinterest.R
import com.example.placesofinterest.adapters.PlaceAdapter
import com.example.placesofinterest.dataClasses.Place
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    // create an ArrayList of the different Data items. Create a local adapter.
    private val places = arrayListOf<Place>()
    private val placeAdapter = PlaceAdapter(places)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
    }


    // initialize a staggeredgridlayout (different sizes per item unlike Grid which is same size)
    // fill places by doing an advanced for loop.
    // notify that the dataset has changed, really cool!
    private fun initViews() {
        rvPlaces.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        rvPlaces.adapter = placeAdapter

        for (i in Place.PLACE_NAMES.indices) {
            places.add(Place(Place.PLACE_NAMES[i], Place.PLACE_RES_DRAWABLE_IDS[i]))
        }
        placeAdapter.notifyDataSetChanged()
    }
}

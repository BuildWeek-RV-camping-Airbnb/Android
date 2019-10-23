package com.Lambda.rv_camping.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.Lambda.rv_camping.R
import com.Lambda.rv_camping.model.CampingSpots
import com.Lambda.rv_camping.model.Properties
import kotlinx.android.synthetic.main.item_property_view.view.*
import kotlinx.android.synthetic.main.item_view.view.*

class PropertiesAdapter (private val propertyList: MutableList<Properties>) : RecyclerView.Adapter<PropertiesAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_property_view, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return propertyList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentProperty = propertyList[position]

        holder.propertyName.text = currentProperty.property_name
        holder.description.text = currentProperty.description
        holder.address.text = currentProperty.address
        holder.city.text = currentProperty.city
        holder.state.text = currentProperty.state
        val price = "$ " + currentProperty.price.toString()
        holder.price.text = price
        val rating = currentProperty.rating.toString() + "/5"
        holder.rating.text = rating
    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val propertyName: TextView = itemView.tv_property_name
        val description: TextView = itemView.tv_property_description
        val address: TextView = itemView.tv_property_address
        val city: TextView = itemView.tv_property_city
        val state: TextView = itemView.tv_property_state
        val price: TextView = itemView.tv_property_price
        val rating: TextView = itemView.tv_property_rating

    }

}
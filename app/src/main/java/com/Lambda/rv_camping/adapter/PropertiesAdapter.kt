package com.Lambda.rv_camping.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.Lambda.rv_camping.R
import com.Lambda.rv_camping.model.CampingSpots
import com.Lambda.rv_camping.model.Properties
import com.Lambda.rv_camping.model.Property
import com.Lambda.rv_camping.ui.activities.ReservePlaceActivity
import kotlinx.android.synthetic.main.item_property_view.view.*
import kotlinx.android.synthetic.main.item_view.view.*

class PropertiesAdapter (private val properties: MutableList<Property>?) : RecyclerView.Adapter<PropertiesAdapter.ViewHolder>() {

    private var context: Context? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_property_view, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        if (properties != null) {
            return properties.size
        }
        return 10
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentProperty = properties?.get(position)

        holder.propertyName.text = currentProperty?.property_name
        holder.description.text = currentProperty?.description
        holder.address.text = currentProperty?.address
        holder.city.text = currentProperty?.city
        holder.state.text = currentProperty?.state
        val price = "$" + currentProperty?.price.toString() + " Per Day"
        holder.price.text = price
        val rating = "Rating: " + currentProperty?.rating.toString() + "/5"
        holder.rating.text = rating

        holder.reserve.setOnClickListener {
            val intent = Intent(context, ReservePlaceActivity::class.java)


            intent.putExtra("name", currentProperty?.property_name)
            intent.putExtra("description", currentProperty?.description)
            intent.putExtra("address", currentProperty?.address)
            intent.putExtra("city", currentProperty?.city)
            intent.putExtra("state", currentProperty?.state)
            intent.putExtra("price", price)
            intent.putExtra("rating", rating)

            context?.startActivity(intent)
        }
    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val propertyName: TextView = itemView.tv_property_name
        val description: TextView = itemView.tv_property_description
        val address: TextView = itemView.tv_property_address
        val city: TextView = itemView.tv_property_city
        val state: TextView = itemView.tv_property_state
        val price: TextView = itemView.tv_property_price
        val rating: TextView = itemView.tv_property_rating
        val reserve: Button = itemView.btn_property_reserve
    }

}
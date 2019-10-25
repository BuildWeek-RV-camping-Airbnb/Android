package com.Lambda.rv_camping.adapter

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.Lambda.rv_camping.R
import com.Lambda.rv_camping.model.CampingSpots
import com.Lambda.rv_camping.model.Properties
import com.Lambda.rv_camping.model.Property
import com.Lambda.rv_camping.networking.ApiBuilder
import com.Lambda.rv_camping.ui.activities.ReservePlaceActivity
import com.Lambda.rv_camping.ui.controllers.LoginController
import com.Lambda.rv_camping.ui.fragments.DateFragmentFrom
import com.Lambda.rv_camping.ui.fragments.DateFragmentTo
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_property_view.view.*
import kotlinx.android.synthetic.main.item_view.view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PropertiesAdapter(private var properties: MutableList<Property>?) :
    RecyclerView.Adapter<PropertiesAdapter.ViewHolder>() {

    private var context: Context? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_property_view, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        if (properties != null) {
            return properties!!.size
        }
        return 10
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentProperty = properties?.get(position)

        // If the url link is longer than 10, then get the image from the url. Else use a default image.
        val imageSuffix = currentProperty?.image.toString()
        if(currentProperty?.image.toString().endsWith("jpg")){
            Picasso.get().load(currentProperty?.image).into(holder.image)
        }



        holder.propertyName.text = currentProperty?.property_name
        holder.description.text = currentProperty?.description
        holder.address.text = currentProperty?.address
        holder.city.text = currentProperty?.city
        holder.state.text = currentProperty?.state
        val price = "$" + currentProperty?.price.toString() + " Per Day"
        holder.price.text = price
        var rating: String = ""
        if(currentProperty?.rating == null) {
            rating = "No Reviews Yet"
        }
        else{
            rating = "Rating: " + currentProperty?.rating.toString() + "/5"
        }

        holder.rating.text = rating

        if (LoginController.isOwner) {
            holder.reserve.text = "Delete Listing"
            holder.reserve.setOnClickListener {
                val builder = AlertDialog.Builder(context)
                builder.setTitle("Delete Confirmation")
                builder.setMessage("Are you sure you want to delete this property?")
                builder.setPositiveButton("YES") { dialogInterface, i ->
                    holder.cardViewDeleteOnLongPress(position)
                    if (currentProperty != null) {
                        deleteProperty(currentProperty.id)
                    }
                    Toast.makeText(
                        context,
                        "Property has been successfully deleted",
                        Toast.LENGTH_SHORT
                    ).show()
                }
                builder.setNegativeButton("NO"){dialogInterface, i ->
                    dialogInterface.dismiss()
                }
                builder.show()
            }

        } else {
            holder.reserve.text = "Reserve Property"
            holder.reserve.setOnClickListener {
                val intent = Intent(context, ReservePlaceActivity::class.java)

                intent.putExtra("name", currentProperty?.property_name)
                intent.putExtra("description", currentProperty?.description)
                intent.putExtra("address", currentProperty?.address)
                intent.putExtra("city", currentProperty?.city)
                intent.putExtra("state", currentProperty?.state)
                intent.putExtra("price", price)
                intent.putExtra("rating", rating)


                var btnClicked: Boolean = false



                if (btnClicked == false) {
                    btnClicked = true
                    intent.putExtra("startDate", "YYYY-MM-DD") ?: "YYYY-MM-DD"
                    intent.putExtra("endDate", "YYYY-MM-DD")
                }

                if (btnClicked == true) {
                    btnClicked = false
                    intent.putExtra("startDate", DateFragmentTo.startDate) ?: "YYYY-MM-DD"
                    intent.putExtra("endDate", DateFragmentFrom.endDate)
                }


                context?.startActivity(intent)

                holder.reserve.text = "Reservation Information"
            }
        }


    }


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val image: ImageView? = itemView.iv_property_image
        val propertyName: TextView = itemView.tv_property_name
        val description: TextView = itemView.tv_property_description
        val address: TextView = itemView.tv_property_address
        val city: TextView = itemView.tv_property_city
        val state: TextView = itemView.tv_property_state
        val price: TextView = itemView.tv_property_price
        val rating: TextView = itemView.tv_property_rating
        val reserve: Button = itemView.btn_property_reserve

        fun cardViewDeleteOnLongPress(itemPosition: Int) {
            LoginController.properties?.removeAt(itemPosition)
            updateRV(LoginController.properties)
        }
    }

    fun updateRV(newList: MutableList<Property>?) {
        properties = newList
        notifyDataSetChanged()
    }

    fun deleteProperty(id: Int){
        val call: Call<Void> = ApiBuilder.create().deleteProperty(LoginController.token, id)
        call.enqueue(object: Callback<Void> {
            override fun onFailure(call: Call<Void>, t: Throwable) {
                Log.i("Add Property", "OnFailure ${t.message}")
            }

            override fun onResponse(call: Call<Void>, response: Response<Void>) {
                if(response.isSuccessful){
                    Log.i("Delete Property", "OnResponseSuccess ${response.message()}")

                }
                else{
                    Log.i("Add Property", "OnResponseFailure ${response.errorBody()}")
                }
            }

        })
    }

}
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
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val propertyName: TextView = itemView.tv_property_name

        /*
        val image: ImageView = itemView.findViewById(R.id.iv_product)
        val title: TextView = itemView.findViewById(R.id.tv_title)
        val price: TextView = itemView.findViewById(R.id.tv_price)
        val productOnSale: ImageView = itemView.iv_sale*/
    }

}

/*
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.product_row, parent, false)
        val holder = ViewHolder(view)
        view.setOnClickListener {
        val intent = Intent(parent.context, ProductDetails::class.java)
            intent.putExtra("title", products[holder.adapterPosition].title)
            intent.putExtra("photo_url", products[holder.adapterPosition].photoUrl)
            intent.putExtra("price", products[holder.adapterPosition].price)
            parent.context.startActivity(intent)
        }

        return holder
    }
 */
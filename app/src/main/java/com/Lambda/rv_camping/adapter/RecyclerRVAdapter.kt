package com.Lambda.rv_camping.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.Lambda.rv_camping.R

import com.Lambda.rv_camping.model.CampingSpots
import com.Lambda.rv_camping.ui.activities.MainActivity
import com.Lambda.rv_camping.ui.controllers.ItemDetailController
import com.Lambda.rv_camping.ui.controllers.MainActivityController
import com.bluelinelabs.conductor.Conductor
import com.bluelinelabs.conductor.RouterTransaction
import com.bluelinelabs.conductor.changehandler.HorizontalChangeHandler
import kotlinx.android.synthetic.main.item_view.view.*

class RecyclerRVAdapter (private val dataList: MutableList<CampingSpots>)
    : RecyclerView.Adapter<RecyclerRVAdapter.MyViewHolder>(){

    val spots = mutableListOf<CampingSpots>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        context = parent.context
        val view = LayoutInflater.from(context).inflate(R.layout.item_view, parent, false)
        return MyViewHolder(view)




    }

    override fun getItemCount(): Int {
            return dataList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val data = dataList[position]
        holder.detail.text = data.id.toString()

        holder.itemView



    }

    private var context: Context? = null

    class MyViewHolder(view: View): RecyclerView.ViewHolder(view){

        val detail: TextView =view.textView


    }
    fun updateItems(spots: List<CampingSpots>){
        this.spots.clear()
        this.spots.addAll(spots)
        notifyDataSetChanged()
    }

}
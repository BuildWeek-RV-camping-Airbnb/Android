package com.Lambda.rv_camping.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.Lambda.rv_camping.R

import com.Lambda.rv_camping.model.CampingSpots
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
        holder.detail.text = data.details.toString()

        holder.button.setOnClickListener {
            Toast.makeText(context, "Position : $position", Toast.LENGTH_LONG).show()
        }
    }

    private var context: Context? = null

    class MyViewHolder(view: View): RecyclerView.ViewHolder(view){

        val detail: TextView =view.textView
        val button = view.mButtonReserve

    }
  // fun updateItems(spots: List<CampingSpots>){
  //     this.spots.clear()
  //     this.spots.addAll(spots)
  //     notifyDataSetChanged()
  // }

}
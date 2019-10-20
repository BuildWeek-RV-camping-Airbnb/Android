package com.Lambda.rv_camping.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.Lambda.rv_camping.R

import com.Lambda.rv_camping.model.CampingSpots
import kotlinx.android.synthetic.main.item_view.view.*

class RecyclerRVAdapter (private val dataList: MutableList<CampingSpots>)
    : RecyclerView.Adapter<RecyclerRVAdapter.MyViewHolder>(){
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
        holder.detail.text = data.toString()

    }

    private var context: Context? = null

    class MyViewHolder(view: View): RecyclerView.ViewHolder(view){

        val detail: TextView =view.textView
    }

}
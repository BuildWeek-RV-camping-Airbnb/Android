package com.Lambda.rv_camping.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.Lambda.rv_camping.R
import com.Lambda.rv_camping.R.color.colorAccent
import com.Lambda.rv_camping.R.color.someColor

import com.Lambda.rv_camping.model.CampingSpots
import com.Lambda.rv_camping.ui.activities.ReservePlaceActivity
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
//if reservers
        if(data.isReserved == true) {


            holder.button.visibility = View.GONE
        }
            holder.button.setOnClickListener {
                data.isReserved = true
                    notifyDataSetChanged()

            val intent = Intent(context, ReservePlaceActivity::class.java)
            context?.startActivity(intent)



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
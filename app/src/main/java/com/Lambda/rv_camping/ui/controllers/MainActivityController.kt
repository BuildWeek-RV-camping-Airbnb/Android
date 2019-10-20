package com.Lambda.rv_camping.ui.controllers

import android.os.Bundle
import android.telecom.Call
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.Lambda.rv_camping.R
import com.Lambda.rv_camping.model.CampingSpots
import com.bluelinelabs.conductor.Controller
import com.bluelinelabs.conductor.RouterTransaction
import com.bluelinelabs.conductor.changehandler.HorizontalChangeHandler
import kotlinx.android.synthetic.main.item_view.view.*

class MainActivityController : Controller{
    constructor(): super()
    constructor(args: Bundle?):super(args)

    val campingList = mutableListOf(
        CampingSpots("djlkj","1"),
        CampingSpots("ds","2")
    )





    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup): View {
        val view = inflater.inflate(R.layout.activity_main, container, false)

        view?.mButtonReserve?.setOnClickListener {

            router?.pushController(
                RouterTransaction.with(ItemDetailController())
                    .pushChangeHandler(HorizontalChangeHandler())
                    .popChangeHandler(HorizontalChangeHandler())
            )
        }
        return view
    }





}


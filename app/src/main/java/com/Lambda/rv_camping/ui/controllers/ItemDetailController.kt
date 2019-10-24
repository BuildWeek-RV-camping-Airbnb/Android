package com.Lambda.rv_camping.ui.controllers

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.Lambda.rv_camping.R
import com.Lambda.rv_camping.model.CampingSpots
import com.Lambda.rv_camping.ui.activities.MainActivity
import com.bluelinelabs.conductor.Controller
import com.bluelinelabs.conductor.ControllerChangeHandler
import com.bluelinelabs.conductor.ControllerChangeType
import kotlinx.android.synthetic.main.item_view.view.*

class ItemDetailController : Controller() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup): View {
        val view = inflater.inflate(R.layout.controller_add_property, container, false)


        return view


    }

}


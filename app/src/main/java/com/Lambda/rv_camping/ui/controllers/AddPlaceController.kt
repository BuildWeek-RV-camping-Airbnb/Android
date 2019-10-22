package com.Lambda.rv_camping.ui.controllers

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.Lambda.rv_camping.R
import com.Lambda.rv_camping.model.CampingSpots
import com.Lambda.rv_camping.ui.activities.MainActivity
import com.Lambda.rv_camping.util.getString
import com.bluelinelabs.conductor.Controller
import com.bluelinelabs.conductor.RouterTransaction
import com.bluelinelabs.conductor.changehandler.HorizontalChangeHandler
import kotlinx.android.synthetic.main.activity_add_place.view.*

class AddPlaceController : Controller{

    constructor(): super()
    constructor(args: Bundle?):super(args)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup): View {
     val view = inflater.inflate(R.layout.activity_add_place, container, false)
        view?.mButtonAddPlace?.setOnClickListener {
            val spot = mutableListOf<CampingSpots>()
            val title = view.mTitleText.getString()
            val detail =  view.mDescriptionText.getString()
         //  for (it in spot) {
         //      spot.add(CampingSpots(property_name, description))
         //  }
            MainController.campingList.add(CampingSpots(title, detail))
            args.putSerializable(MainActivity.BUNDLE_KEY,  CampingSpots(title, detail) )

            router.pushController(
                RouterTransaction.with(MainController(args))
                    .pushChangeHandler(HorizontalChangeHandler())
                    .popChangeHandler(HorizontalChangeHandler())
            )

        }
    return view
    }

}
package com.Lambda.rv_camping.ui.controllers

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import com.Lambda.rv_camping.R
import com.Lambda.rv_camping.adapter.RecyclerRVAdapter
import com.Lambda.rv_camping.model.CampingSpots
import com.Lambda.rv_camping.ui.activities.MainActivity
import com.bluelinelabs.conductor.Controller
import com.bluelinelabs.conductor.ControllerChangeHandler
import com.bluelinelabs.conductor.ControllerChangeType
import com.bluelinelabs.conductor.RouterTransaction
import com.bluelinelabs.conductor.changehandler.HorizontalChangeHandler
import kotlinx.android.synthetic.main.activity_add_place.view.*
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.android.synthetic.main.item_view.view.*
import okhttp3.internal.notify

class MainController : Controller {

    companion object {
        val campingList = mutableListOf(
            CampingSpots("djlkj", "1"),
            CampingSpots("ds", "2")

        )
        val BUNDLE_KEY = "key"
        val rvAdapter = RecyclerRVAdapter(campingList)
    }
    constructor() : super()
    constructor(args: Bundle?) : super(args){
        args?.getSerializable(MainActivity.BUNDLE_KEY)
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup): View {


        val view = inflater.inflate(R.layout.activity_main, container, false)

        view?.myButton?.setOnClickListener {
            router.pushController(
                RouterTransaction.with(AddPlaceController())
                    .pushChangeHandler(HorizontalChangeHandler())
                    .popChangeHandler(HorizontalChangeHandler()))
        }
        view.vRecycle.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = RecyclerRVAdapter(campingList)


        }


        return view
    }
    override fun onChangeEnded(
        changeHandler: ControllerChangeHandler,
        changeType: ControllerChangeType
    ) {
        super.onChangeEnded(changeHandler, changeType)
        view?.findViewById<Button>(R.id.mButtonAddPlace)?.setOnClickListener {
            router.pushController(RouterTransaction.with(AddPlaceController(args))
                .pushChangeHandler(HorizontalChangeHandler())
                .popChangeHandler(HorizontalChangeHandler())
            )
        }
    }
}




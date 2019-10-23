package com.Lambda.rv_camping.ui.controllers

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.Lambda.rv_camping.R
import com.Lambda.rv_camping.adapter.PropertiesAdapter
import com.Lambda.rv_camping.adapter.RecyclerRVAdapter
import com.Lambda.rv_camping.model.CampingSpots
import com.Lambda.rv_camping.model.Properties
import com.Lambda.rv_camping.model.Property
import com.Lambda.rv_camping.model.User
import com.Lambda.rv_camping.networking.ApiBuilder
import com.Lambda.rv_camping.networking.PlaceApiBuilder
import com.Lambda.rv_camping.ui.activities.MainActivity
import com.Lambda.rv_camping.util.show
import com.bluelinelabs.conductor.Controller
import com.bluelinelabs.conductor.ControllerChangeHandler
import com.bluelinelabs.conductor.ControllerChangeType
import com.bluelinelabs.conductor.RouterTransaction
import com.bluelinelabs.conductor.changehandler.HorizontalChangeHandler
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.android.synthetic.main.controller_login.view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainController : Controller {

    companion object {
        val campingList = mutableListOf(
            CampingSpots("HWY 66",
                "This cool place is on Mile marker nine of HWY 66. Great view and area for kids to play on",

                "1009 wilyamson rd",
                4.99f
                ),
            CampingSpots("UFO Campground",
                "Located at 99 S Ute Dr Nevada Desert, Nevada, 10111. This location is great for campers that like UFOs",

                "11111 sams dr",
                4.99f)

        )

        val propertyList = mutableListOf<Property>(
            Property(1, "testName", "testDescription", "testAddress", "testCity",
                "testState", "testImage", 1, 1, 1)
        )
    }


    constructor() : super()
    constructor(args: Bundle?) : super(args){
        args?.getSerializable(MainActivity.BUNDLE_KEY)
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup): View {


        val view = inflater.inflate(R.layout.activity_main, container, false)

        //getAllProperties()

        view?.myButton?.setOnClickListener {
            router.pushController(
                RouterTransaction.with(AddPlaceController())
                    .pushChangeHandler(HorizontalChangeHandler())
                    .popChangeHandler(HorizontalChangeHandler()))
        }
        /*view.vRecycle.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = RecyclerRVAdapter(campingList)
        }*/


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
    /*
    fun getAllPropertiesNotInUse(){
        val call: Call<List<CampingSpots>> = PlaceApiBuilder.create().getAllProperties()
        call.enqueue(object: Callback<List<CampingSpots>> {
            override fun onFailure(call: Call<List<CampingSpots>>, t: Throwable) {
                Log.i("Networking:", "OnFailure ${t.message}")
            }

            override fun onResponse(call: Call<List<CampingSpots>>, response: Response<List<CampingSpots>>) {
                if(response.isSuccessful){
                    Log.i("Networking", "123 ${response.body()}")

                    }



            }

        })
    }*/


}




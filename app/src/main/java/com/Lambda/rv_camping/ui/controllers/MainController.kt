package com.Lambda.rv_camping.ui.controllers

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.recyclerview.widget.LinearLayoutManager
import com.Lambda.rv_camping.R
import com.Lambda.rv_camping.adapter.PropertiesAdapter
import com.Lambda.rv_camping.model.CampingSpots
import com.Lambda.rv_camping.model.Properties
import com.Lambda.rv_camping.model.Property
import com.Lambda.rv_camping.networking.ApiBuilder
import com.Lambda.rv_camping.ui.activities.MainActivity
import com.bluelinelabs.conductor.Controller
import com.bluelinelabs.conductor.ControllerChangeHandler
import com.bluelinelabs.conductor.ControllerChangeType
import com.bluelinelabs.conductor.RouterTransaction
import com.bluelinelabs.conductor.changehandler.HorizontalChangeHandler
import com.google.android.gms.maps.GoogleMap


import kotlinx.android.synthetic.main.activity_main.view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response








class MainController : Controller{


    private lateinit var mMap: GoogleMap
    private var item: Properties? = null




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


        var propertyListt = mutableListOf<Property>(
            Property(1, "testName", "testDescription", "testAddress", "testCity",
                "testState", "testImage", 1, 1, 1)
        )
    }


    constructor() : super()
    constructor(args: Bundle?) : super(args){
        args?.getSerializable(MainActivity.BUNDLE_KEY)
    }

    override fun onChangeEnded(
        changeHandler: ControllerChangeHandler,
        changeType: ControllerChangeType
    ) {
        super.onChangeEnded(changeHandler, changeType)

        view?.vRecycle?.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = PropertiesAdapter(LoginController.properties)

        }

    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup): View {

        getAllProperties()

        val view = inflater.inflate(R.layout.activity_main, container, false)


        view?.btn_main_add_property?.setOnClickListener {
            router.pushController(
                RouterTransaction.with(AddPropertyController())
                    .pushChangeHandler(HorizontalChangeHandler())
                    .popChangeHandler(HorizontalChangeHandler()))
        }
        return view
    }

    fun getAllProperties(){
        val call: Call<Properties> = ApiBuilder.create().getAllProperties(LoginController.token)

        call.enqueue(object: Callback<Properties> {
            override fun onFailure(call: Call<Properties>, t: Throwable) {
                Log.i("Properties ", "onFailure ${t.message}")
            }

            override fun onResponse(call: Call<Properties>, response: Response<Properties>) {
                if(response.isSuccessful){
                    var list = response.body()
                    LoginController.properties = list?.properties
                    view?.vRecycle?.apply {
                        layoutManager = LinearLayoutManager(activity)
                        adapter = PropertiesAdapter(LoginController.properties)

                        if(LoginController.isOwner == false){
                            view?.btn_main_add_property?.visibility = View.GONE
                        }
                        else{
                            view?.btn_main_add_property?.visibility = View.VISIBLE
                        }
                    }
                }
                else{
                    Log.i("Properties ", "OnResponseFailure ${response.errorBody()}")
                }
            }

        })
    }




}




package com.Lambda.rv_camping.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.Lambda.rv_camping.R
import com.Lambda.rv_camping.adapter.PropertiesAdapter
import com.Lambda.rv_camping.adapter.RecyclerRVAdapter
import com.Lambda.rv_camping.model.CampingSpots
import com.Lambda.rv_camping.ui.controllers.LoginController
import com.Lambda.rv_camping.ui.controllers.MainController
import com.bluelinelabs.conductor.Conductor
import com.bluelinelabs.conductor.Router
import com.bluelinelabs.conductor.RouterTransaction
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*

class MainActivity : AppCompatActivity() {

    private lateinit var router: Router
    private val container: ViewGroup by lazy {
        this.findViewById<ViewGroup>(R.id.cl_activity_main_parent)
    }
    companion object {
        val campingList = mutableListOf(
            CampingSpots("djlkj", "1","1 sams sd", 1f),
            CampingSpots("ds", "2","fsd", 42f)

        )
        val BUNDLE_KEY = "key"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        /*vRecycle.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = RecyclerRVAdapter(campingList)

        }*/

        if(LoginController.isOwner == false){
            btn_main_add_property.visibility = View.GONE
        }


        vRecycle?.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            //adapter = PropertiesAdapter(MainController.propertyList)
        }
        
        // Could have also just use cl_activity_main_parent instead of container
            router = Conductor.attachRouter(this, container, savedInstanceState)
            if (!router.hasRootController()) {
                router.setRoot(RouterTransaction.with(LoginController()))



            }





    }




    override fun onBackPressed(){
        router.popCurrentController()
    }


}

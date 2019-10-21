package com.Lambda.rv_camping.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.Lambda.rv_camping.R
import com.Lambda.rv_camping.adapter.RecyclerRVAdapter
import com.Lambda.rv_camping.model.CampingSpots
import com.Lambda.rv_camping.ui.controllers.ItemDetailController
import com.Lambda.rv_camping.ui.controllers.LoginController
import com.Lambda.rv_camping.ui.controllers.MainActivityController
import com.bluelinelabs.conductor.Conductor
import com.bluelinelabs.conductor.Router
import com.bluelinelabs.conductor.RouterTransaction
import com.bluelinelabs.conductor.changehandler.HorizontalChangeHandler
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.item_view.*
import kotlinx.android.synthetic.main.item_view.view.*

class MainActivity : AppCompatActivity() {

    private lateinit var router: Router
    private val container: ViewGroup by lazy {
        this.findViewById<ViewGroup>(R.id.cl_activity_main_parent)
    }
    private val campingList = mutableListOf(
        CampingSpots("djlkj","1"),
        CampingSpots("ds","2"))

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Could have also just use cl_activity_main_parent instead of container
            router = Conductor.attachRouter(this, container, savedInstanceState)
            if (!router.hasRootController()) {
                router.setRoot(RouterTransaction.with(MainActivityController()))

                vRecycle.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = RecyclerRVAdapter(campingList)
                }

            }





    }




    override fun onBackPressed(){
        router.popCurrentController()
    }


}

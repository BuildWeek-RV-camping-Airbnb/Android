package com.Lambda.rv_camping.ui.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.Lambda.rv_camping.R
import com.Lambda.rv_camping.adapter.PropertiesAdapter
import com.Lambda.rv_camping.adapter.RecyclerRVAdapter
import com.Lambda.rv_camping.model.CampingSpots
import com.Lambda.rv_camping.ui.controllers.AddPropertyController
import com.Lambda.rv_camping.ui.controllers.LoginController
import com.Lambda.rv_camping.ui.controllers.MainController
import com.bluelinelabs.conductor.Conductor
import com.bluelinelabs.conductor.Router
import com.bluelinelabs.conductor.RouterTransaction
import com.bluelinelabs.conductor.changehandler.HorizontalChangeHandler
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*
import okhttp3.internal.wait

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
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.als_options_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.menu_add_property -> startActivity(Intent(this, AddPlaceActivity::class.java))

            R.id.menu_see_on_map -> startActivity(Intent(this, MapsActivity::class.java))
            R.id.menu_sort -> Toast.makeText(this, "Your content has been added to the bottom", Toast.LENGTH_LONG).show()
            R.id.menu_sign_out -> startActivity(Intent(this, MainActivity::class.java))
        }
        return super.onOptionsItemSelected(item)
    }



    override fun onBackPressed(){
        router.popCurrentController()
    }


}

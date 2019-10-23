package com.Lambda.rv_camping.ui.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup
import com.Lambda.rv_camping.R
import com.Lambda.rv_camping.model.CampingSpots
import com.bluelinelabs.conductor.Router
import kotlinx.android.synthetic.main.controller_add_property.*

class AddPlaceActivity : AppCompatActivity() {

    private lateinit var router: Router

    private val container: ViewGroup by lazy {
        this.findViewById<ViewGroup>(R.id.mAddPlaceLayout)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.controller_add_property)


        mButtonAddPlace.setOnClickListener {
            confirmAddPlace()
        }

    }

   fun confirmAddPlace(){
        val title = mTitleText.text.toString().trim()
        val address = mAddressText.text.toString().trim()
        val description = mDescriptionText.text.toString().trim()
        val price = mPriceText.text.toString().trim()


        MainActivity.campingList.add(CampingSpots(title, address, description, price.toFloat()))

        val intent = Intent(this@AddPlaceActivity, MainActivity::class.java)
        startActivity(intent)

    }

}

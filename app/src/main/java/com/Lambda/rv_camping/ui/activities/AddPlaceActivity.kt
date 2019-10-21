package com.Lambda.rv_camping.ui.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup
import com.Lambda.rv_camping.R
import com.Lambda.rv_camping.model.CampingSpots
import com.bluelinelabs.conductor.Router
import kotlinx.android.synthetic.main.activity_add_place.*

class AddPlaceActivity : AppCompatActivity() {

    private lateinit var router: Router

    private val container: ViewGroup by lazy {
        this.findViewById<ViewGroup>(R.id.mAddPlaceLayout)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_place)


        mButtonAddPlace.setOnClickListener {
            confirmAddPlace()
        }

    }

   fun confirmAddPlace(){
        val title = mTitleText.text.toString().trim()
        val description = mDescriptionText.text.toString().trim()

        MainActivity.campingList.add(CampingSpots(title, description))
        val intent = Intent(this@AddPlaceActivity, MainActivity::class.java)
        startActivity(intent)

    }

}

package com.Lambda.rv_camping.ui.activities

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.graphics.drawable.AnimationDrawable
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.Lambda.rv_camping.R
import com.Lambda.rv_camping.ui.controllers.MainController
import com.Lambda.rv_camping.ui.fragments.DateFragmentFrom
import com.Lambda.rv_camping.ui.fragments.DateFragmentTo
import com.Lambda.rv_camping.util.toast
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_reserve_place.*

class ReservePlaceActivity() : AppCompatActivity() {

    var player: MediaPlayer? = null

    companion object {
        const val PASSED_DATE = "999"
        const val PASSING_DATE_INT_ID = 1
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reserve_place)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN

        val animDrawable = root_layout.background as AnimationDrawable
        animDrawable.setEnterFadeDuration(5)
        animDrawable.setExitFadeDuration(2500)
        animDrawable.start()

        player = MediaPlayer.create(this, R.raw.accomplished)

        val name = intent.getStringExtra("name")
        val description = intent.getStringExtra("description")
        val address = intent.getStringExtra("address")
        val city = intent.getStringExtra("city")
        val state = intent.getStringExtra("state")
        val price = intent.getStringExtra("price")
        val rating = intent.getStringExtra("rating")
        val image = intent.getStringExtra("image")
        val startDate = intent.getStringExtra("startDate")
        val endDate = intent.getStringExtra("endDate")

        tv_property_name.text = name
        tv_property_description.text = description
        tv_property_address.text = address
        tv_property_city.text = city
        tv_property_state.text = state
        tv_property_price.text = price
        tv_property_rating.text = rating

        if((image.toString().endsWith("jpeg")) ||
            (image.toString().endsWith("jpg")) ||
            (image.toString().contains("auto"))){
            Picasso.get().load(image).into(iv_property_image)
        }

        tv_reserve_date_start.text = endDate ?: "YYYY-MM-DD"
        tv_reserve_date_end.text = startDate ?: "YYYY-MM-DD"

        tv_reserve_date_start.setOnClickListener {

            player?.start()
            val fragment = DateFragmentFrom()
            fragment.show(supportFragmentManager, "datePickerFrom")
        }

        tv_reserve_date_end.setOnClickListener {
            player?.start()
            val fragment = DateFragmentTo()
            fragment.show(supportFragmentManager, "datePickerTo")
        }

        btn_property_reserve.setOnClickListener {
            player?.start()
            finish()
            this.toast("Successfully Reserved")
        }

    }
}

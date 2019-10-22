package com.Lambda.rv_camping.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.Lambda.rv_camping.R
import com.Lambda.rv_camping.ui.fragments.DateFragmentTo
import kotlinx.android.synthetic.main.activity_reserve_place.*

class ReservePlaceActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reserve_place)

        mTextDateTo.setOnClickListener {
            val fragment = DateFragmentTo()
            fragment.show(supportFragmentManager, "datePicker")
        }

        mButtonReservePlace.setOnClickListener {
           finish()
        }
    }
}

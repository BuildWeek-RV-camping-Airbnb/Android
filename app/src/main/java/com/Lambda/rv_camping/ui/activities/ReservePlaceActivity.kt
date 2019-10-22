package com.Lambda.rv_camping.ui.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.Lambda.rv_camping.R
import com.Lambda.rv_camping.ui.controllers.MainController
import com.Lambda.rv_camping.ui.fragments.DateFragmentFrom
import com.Lambda.rv_camping.ui.fragments.DateFragmentTo
import kotlinx.android.synthetic.main.activity_reserve_place.*

class ReservePlaceActivity : AppCompatActivity() {

    companion object{
        const val PASSED_DATE = "Passed Date"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reserve_place)



        mTextDateFrom.setOnClickListener {
            val fragment = DateFragmentFrom()
            fragment.show(supportFragmentManager, "datePickerFrom")
        }

        mTextDateTo.setOnClickListener {
            val fragment = DateFragmentTo()
            fragment.show(supportFragmentManager, "datePickerTo")
        }

        mButtonReservePlace.setOnClickListener {
            val dateIntent = Intent(this, MainController::class.java)
            dateIntent.putExtra(PASSED_DATE, "Successfully reserved for: $mTextDateFrom until $mTextDateTo")
           finish()



        }

    }
}

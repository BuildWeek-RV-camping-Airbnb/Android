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
        const val PASSED_DATE = "999"
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
        val dateFrom = mTextDateFrom?.text.toString()
        val dateTo = mTextDateTo?.text.toString()
        mButtonReservePlace.setOnClickListener {
            val dateIntent = Intent(this, ReservePlaceActivity::class.java)
            dateIntent.putExtra(PASSED_DATE, "Successfully reserved for: $dateFrom $dateTo")
           finish()



        }

    }
}

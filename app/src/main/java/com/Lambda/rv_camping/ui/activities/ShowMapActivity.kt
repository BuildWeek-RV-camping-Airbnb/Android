package com.Lambda.rv_camping.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.Lambda.rv_camping.R
/*(this is an activity to show the location of the rv spot
(in the card view we will set up the button to take you to this screen))*/
class ShowMapActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_map)
    }
}

package com.Lambda.rv_camping.ui.controllers

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.Lambda.rv_camping.R
import com.bluelinelabs.conductor.Controller
import com.bluelinelabs.conductor.RouterTransaction
import com.bluelinelabs.conductor.changehandler.HorizontalChangeHandler
import kotlinx.android.synthetic.main.controller_login.view.*

class LoginController : Controller(){
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup): View {
        val view = inflater.inflate(R.layout.controller_login, container, false)

        view.btn_register.setOnClickListener {
            //Makes it so that the view transitions to Register Controller
            router.pushController(
                RouterTransaction.with(RegisterController())
                    //Gives the transition a horizontal slide animation going from MultiplyControl to ResultControl
                    .pushChangeHandler(HorizontalChangeHandler())
                    //Gives the transition a horizontal slide when going backwards.
                    .popChangeHandler(HorizontalChangeHandler()))
        }
        return view
    }

}
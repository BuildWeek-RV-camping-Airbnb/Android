package com.Lambda.rv_camping.ui.controllers

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.Lambda.rv_camping.R
import com.bluelinelabs.conductor.Controller

class RegisterController : Controller(){
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup): View {
        val view = inflater.inflate(R.layout.controller_register, container, false)

        return view
    }

}
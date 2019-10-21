package com.Lambda.rv_camping.ui.controllers

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.Lambda.rv_camping.R
import com.bluelinelabs.conductor.Controller
import com.bluelinelabs.conductor.RouterTransaction
import com.bluelinelabs.conductor.changehandler.HorizontalChangeHandler
import kotlinx.android.synthetic.main.item_view.*
import kotlinx.android.synthetic.main.item_view.view.*

class ItemDetailController : Controller{



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup): View {
        val view = inflater.inflate(R.layout.item_view, container,false)




        view.textView.text = "this is just placeholder text that eventually will be passed around from detail view"
        view.mButtonReserve?.setOnClickListener {
            router.pushController(
                RouterTransaction.with(ItemDetailController())
                    .pushChangeHandler(HorizontalChangeHandler())
                    .popChangeHandler(HorizontalChangeHandler())
            )
        }
        return view



    }

    constructor(): super()
    constructor(args: Bundle?):super(args)


}


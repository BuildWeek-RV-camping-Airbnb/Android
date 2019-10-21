package com.Lambda.rv_camping.ui.controllers

import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import android.os.Bundle
import android.os.Message
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.Lambda.rv_camping.R
import com.Lambda.rv_camping.ui.activities.MainActivity
import com.Lambda.rv_camping.ui.controllers.AddPlaceController.*
import com.bluelinelabs.conductor.Controller
import com.bluelinelabs.conductor.ControllerChangeHandler
import com.bluelinelabs.conductor.ControllerChangeType
import com.bluelinelabs.conductor.RouterTransaction
import com.bluelinelabs.conductor.changehandler.HorizontalChangeHandler
import kotlinx.android.synthetic.main.activity_add_place.view.*
import kotlinx.android.synthetic.main.item_view.*
import kotlinx.android.synthetic.main.item_view.view.*

class ItemDetailController: Controller{
    constructor(): super()
    constructor(args: Bundle?): super(args){
        args?.getStringArrayList(MainActivity.BUNDLE_KEY)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup): View {
        val view = inflater.inflate(R.layout.item_view, container,false)

        val list = args.getStringArrayList(MainActivity.BUNDLE_KEY)

        view.textView.setText(list?.toString())

        return view



    }

    override fun onChangeEnded(
        changeHandler: ControllerChangeHandler,
        changeType: ControllerChangeType
    ) {
        super.onChangeEnded(changeHandler, changeType)
        view?.findViewById<Button>(R.id.mButtonReserve)?.setOnClickListener {
            router.pushController(RouterTransaction.with(AddPlaceController(args))
                        .pushChangeHandler(HorizontalChangeHandler())
                        .popChangeHandler(HorizontalChangeHandler())
                )
            }
        }
    }


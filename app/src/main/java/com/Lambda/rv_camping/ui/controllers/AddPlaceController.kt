package com.Lambda.rv_camping.ui.controllers

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.Lambda.rv_camping.R
import com.Lambda.rv_camping.model.CampingSpots
import com.Lambda.rv_camping.ui.activities.MainActivity
import com.Lambda.rv_camping.util.getString
import com.bluelinelabs.conductor.Controller
import com.bluelinelabs.conductor.RouterTransaction
import com.bluelinelabs.conductor.changehandler.HorizontalChangeHandler
import kotlinx.android.synthetic.main.controller_add_property.view.*

class AddPlaceController : Controller {

    constructor() : super()
    constructor(args: Bundle?) : super(args)

    private var validatedPropertyName: Boolean = false
    private var validatedDescription: Boolean = false
    private var validatedAddress: Boolean = false
    private var validatedCity: Boolean = false
    private var validatedState: Boolean = false
    private var validatedPrice: Boolean = false

    lateinit var propertyName: String
    lateinit var description: String
    lateinit var address: String
    lateinit var city: String
    lateinit var state: String
    private var price: Int? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup): View {
        val view = inflater.inflate(R.layout.controller_add_property, container, false)

        view.btn_property_add.setOnClickListener {
            validatePropertyName()
            validateDescription()
            validateAddress()
            validateCity()
            validateState()
            validatePrice()

            if(validateAllData())
                router.popCurrentController()
        }



        return view
    }

    private fun validatePropertyName(): Boolean{
        propertyName = view?.text_input_add_property_name?.editText?.text.toString().trim()

        if(propertyName.isEmpty()){
            view?.text_input_add_property_name?.error = "Field can't be empty"
            validatedPropertyName = false
            return false
        }
        else{
            view?.text_input_add_property_name?.error = null
            view?.text_input_add_property_name?.isErrorEnabled = false
            validatedPropertyName = true
            return true
        }
    }

    private fun validateDescription(): Boolean{
        description = view?.text_input_add_description?.editText?.text.toString().trim()

        if(description.isEmpty()){
            view?.text_input_add_description?.error = "Field can't be empty"
            validatedDescription = false
            return false
        }
        else{
            view?.text_input_add_description?.error = null
            view?.text_input_add_description?.isErrorEnabled = false
            validatedDescription = true
            return true
        }
    }

    private fun validateAddress(): Boolean{
        address = view?.text_input_add_address?.editText?.text.toString().trim()

        if(address.isEmpty()){
            view?.text_input_add_address?.error = "Field can't be empty"
            validatedAddress = false
            return false
        }
        else{
            view?.text_input_add_address?.error = null
            view?.text_input_add_address?.isErrorEnabled = false
            validatedAddress = true
            return true
        }
    }

    private fun validateCity(): Boolean{
        city = view?.text_input_add_city?.editText?.text.toString().trim()

        if(city.isEmpty()){
            view?.text_input_add_city?.error = "Field can't be empty"
            validatedCity = false
            return false
        }
        else{
            view?.text_input_add_city?.error = null
            view?.text_input_add_city?.isErrorEnabled = false
            validatedCity = true
            return true
        }
    }

    private fun validateState(): Boolean{
        state = view?.text_input_add_state?.editText?.text.toString().trim()

        if(state.isEmpty()){
            view?.text_input_add_state?.error = "Field can't be empty"
            validatedState = false
            return false
        }
        else{
            view?.text_input_add_state?.error = null
            view?.text_input_add_state?.isErrorEnabled = false
            validatedState = true
            return true
        }
    }

    private fun validatePrice(): Boolean{
        val priceString = view?.text_input_price?.editText?.text.toString().trim()
        if(!priceString.isNullOrEmpty()){
            price = priceString.toInt()
        }

        if(price == null){
            view?.text_input_price?.error = "Field can't be empty"
            validatedPrice = false
            return false
        }
        else{
            view?.text_input_price?.error = null
            view?.text_input_price?.isErrorEnabled = false
            validatedPrice = true
            return true
        }
    }

    fun validateAllData(): Boolean {
        return validatedPropertyName && validatedDescription && validatedAddress &&
                validatedCity && validatedState && validatedPrice
    }
}
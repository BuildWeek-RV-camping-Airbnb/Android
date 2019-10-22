package com.Lambda.rv_camping.ui.controllers

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.Lambda.rv_camping.R
import com.bluelinelabs.conductor.Controller
import com.bluelinelabs.conductor.ControllerChangeHandler
import com.bluelinelabs.conductor.ControllerChangeType
import com.bluelinelabs.conductor.RouterTransaction
import com.bluelinelabs.conductor.changehandler.HorizontalChangeHandler
import kotlinx.android.synthetic.main.controller_login.view.*

class LoginController : Controller(){

    private var validatedUsername: Boolean = false
    private var validatedPassword: Boolean = false

    lateinit var username: String
    lateinit var password: String
    
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup): View {
        val view = inflater.inflate(R.layout.controller_login, container, false)

        view.btn_login.setOnClickListener {
            validateUsername()
            validatePassword()

            router.pushController(RouterTransaction.with(MainController())
                .pushChangeHandler(HorizontalChangeHandler())
                .popChangeHandler(HorizontalChangeHandler()))
        }

        view.btn_register.setOnClickListener {
            //Makes it so that the view transitions to Register Controller
            router.pushController(
                RouterTransaction.with(RegisterController())
                    //Gives the transition a horizontal slide animation going from LoginController to RegisterController
                    .pushChangeHandler(HorizontalChangeHandler())
                    //Gives the transition a horizontal slide when popping
                    .popChangeHandler(HorizontalChangeHandler()))
        }
        return view
    }

    //Removes the error messages when transitioning in to the Login Controller
    override fun onChangeStarted(
        changeHandler: ControllerChangeHandler,
        changeType: ControllerChangeType
    ) {
        super.onChangeStarted(changeHandler, changeType)

        view?.text_input_username?.error = null
        view?.text_input_username?.isErrorEnabled = false

        view?.text_input_password?.error = null
        view?.text_input_password?.isErrorEnabled = false
    }

    //Checks to see if the entered username is okay or not.
    private fun validateUsername(): Boolean {
        //Gets the text from the username text input layout
        username = view?.text_input_username?.editText?.text.toString().trim()

        if (username.isEmpty()) {
            view?.text_input_username?.error = "Field can't be empty"
            validatedUsername = false
            return false
        } else if (username.length < 4) {
            view?.text_input_username?.error = "Username should be at least four characters"
            return false
        } else if (username.length > 12) {
            view?.text_input_username?.error = "Username can't be more than 12 characters"
            return false
        } else {
            //Removes the error message if it already exists
            view?.text_input_username?.error = null
            view?.text_input_username?.isErrorEnabled = false
            validatedUsername = true
            return true
        }
    }

    //Checks to see if the entered password is okay or not.
    private fun validatePassword(): Boolean {
        //Gets the text from the password text input layout
        password = view?.text_input_password?.editText?.text.toString().trim()

        if (password.isEmpty()) {
            view?.text_input_password?.error = "Field can't be empty"
            validatedPassword = false
            return false
        } else if (password.length < 4) {
            view?.text_input_password?.error = "Password should be at least four characters"
            return false
        } else if (password.length > 12) {
            view?.text_input_password?.error = "Password can't be more than 12 characters"
            return false
        } else {
            //Removes the error message if it already exists
            view?.text_input_password?.error = null
            view?.text_input_password?.isErrorEnabled = false
            validatedPassword = true
            return true
        }
    }

}
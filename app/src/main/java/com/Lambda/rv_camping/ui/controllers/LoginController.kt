package com.Lambda.rv_camping.ui.controllers

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.Lambda.rv_camping.R
import com.Lambda.rv_camping.model.User
import com.Lambda.rv_camping.model.UserLogin
import com.Lambda.rv_camping.model.UserResponse
import com.Lambda.rv_camping.networking.ApiBuilder
import com.Lambda.rv_camping.util.gone
import com.Lambda.rv_camping.util.show
import com.bluelinelabs.conductor.Controller
import com.bluelinelabs.conductor.ControllerChangeHandler
import com.bluelinelabs.conductor.ControllerChangeType
import com.bluelinelabs.conductor.RouterTransaction
import com.bluelinelabs.conductor.changehandler.HorizontalChangeHandler
import kotlinx.android.synthetic.main.controller_login.view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginController : Controller(){

    // TEST ACCOUNT USERNAME: Jessica PASSWORD: qwerty

    companion object{
        var successfulLogin:Boolean = false
        lateinit var token: String
    }

    private var validatedUsername: Boolean = false
    private var validatedPassword: Boolean = false

    lateinit var username: String
    lateinit var password: String
    
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup): View {
        val view = inflater.inflate(R.layout.controller_login, container, false)
        view.pb_login.gone()

        view.btn_login.setOnClickListener {
            validateUsername()
            validatePassword()

            if(validatedUsername && validatedPassword)
                login()

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
        } else if (username.length < 3) {
            view?.text_input_username?.error = "Username should be at least three characters"
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
        } else if (password.length < 3) {
            view?.text_input_password?.error = "Password should be at least three characters"
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

    fun login(){
        view?.pb_login?.show()
        val call:Call<UserResponse> = ApiBuilder.create().login(UserLogin(username, password))
        call.enqueue(object: Callback<UserResponse>{
            override fun onFailure(call: Call<UserResponse>, t: Throwable) {
                Log.i("Login:", "OnFailure ${t.message}")
            }

            override fun onResponse(call: Call<UserResponse>, response: Response<UserResponse>) {
                if(response.isSuccessful) {
                    Log.i("Login", "Success ${response.body()}")
                    successfulLogin = true
                }
                else{
                    Log.i("Login", "Failure ${response.errorBody()}")
                    successfulLogin = false
                }

                if(successfulLogin){
                    successfulLogin = false
                    router.pushController(RouterTransaction.with(MainController())
                        .pushChangeHandler(HorizontalChangeHandler())
                        .popChangeHandler(HorizontalChangeHandler()))
                }
            }

        })
    }

}

/*
    fun getAllUsers(){
        val call:Call<List<User>> = ApiBuilder.create().getAllUsers()
        call.enqueue(object: Callback<List<User>>{
            override fun onFailure(call: Call<List<User>>, t: Throwable) {
                Log.i("Networking:", "OnFailure ${t.message}")
            }

            override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {
                if(response.isSuccessful){
                    Log.i("Networking", "123 ${response.body()}")
                    val listOfUsers: List<User>? = response.body()
                    listOfUsers?.forEach {
                        if(it.username == username && it.password == password){
                            successfulLogin = true
                            view?.pb_login?.show()
                        }
                    }
                    if(successfulLogin == false){
                        Toast.makeText(activity, "Incorrect Username or Password", Toast.LENGTH_SHORT).show()
                    }
                    if(successfulLogin){
                        successfulLogin = false
                        router.pushController(RouterTransaction.with(MainController())
                            .pushChangeHandler(HorizontalChangeHandler())
                            .popChangeHandler(HorizontalChangeHandler()))
                    }
                }
                else{
                    Log.i("Networking", "456 ${response.errorBody()}")
                }
            }

        })
    }
 */
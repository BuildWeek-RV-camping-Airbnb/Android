package com.Lambda.rv_camping.ui.controllers

import android.util.Patterns
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.Lambda.rv_camping.R
import com.bluelinelabs.conductor.Controller
import kotlinx.android.synthetic.main.controller_register.view.*
import com.Lambda.rv_camping.util.toastRegister

class RegisterController : Controller(){

    private var validatedFirstName: Boolean = false
    private var validatedLastName: Boolean = false
    private var validatedUsername: Boolean = false
    private var validatedEmail: Boolean = false
    private var validatedPassword: Boolean = false

    lateinit var firstName: String
    lateinit var lastName: String
    lateinit var username: String
    lateinit var email: String
    lateinit var password: String

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup): View {
        val view = inflater.inflate(R.layout.controller_register, container, false)

        view.btn_register_create.setOnClickListener {
            validateFirstName()
            validateLastName()
            validateUsername()
            validateEmail()
            validatePassword()

            // If all the information is good, then register the user and go back to login
            if(validateAllData()){
                activity?.toastRegister(firstName)
                router.popToRoot()
            }
        }

        view.btn_cancel_registration.setOnClickListener {
            router.popToRoot()
        }

        return view
    }

    //Checks to see if the entered first name is okay or not.
    private fun validateFirstName(): Boolean {
        //Gets the text from the firstName text input layout
        firstName = view?.text_input_first_name_register?.editText?.text.toString().trim()

        if (firstName.isEmpty()) {
            view?.text_input_first_name_register?.error = "Field can't be empty"
            validatedFirstName = false
            return false
        } else if (firstName.length < 2) {
            view?.text_input_first_name_register?.error = "First name must be at least two characters"
            return false
        } else {
            //Removes the error message if it already exists
            view?.text_input_first_name_register?.error = null
            view?.text_input_first_name_register?.isErrorEnabled = false
            validatedFirstName = true
            return true
        }
    }

    //Checks to see if the entered last name is okay or not.
    private fun validateLastName(): Boolean {
        //Gets the text from the lastName text input layout
        lastName = view?.text_input_last_name_register?.editText?.text.toString().trim()

        if (lastName.isEmpty()) {
            view?.text_input_last_name_register?.error = "Field can't be empty"
            validatedLastName = false
            return false
        } else if (lastName.length < 2) {
            view?.text_input_last_name_register?.error = "Last name must be at least two characters"
            return false
        } else {
            //Removes the error message if it already exists
            view?.text_input_last_name_register?.error = null
            view?.text_input_last_name_register?.isErrorEnabled = false
            validatedLastName = true
            return true
        }
    }

    //Checks to see if the entered email is okay or not.
    private fun validateEmail(): Boolean {
        //Gets the text from the email text input layout
        email = view?.text_input_email_register?.editText?.text.toString().trim()

        if (email.isEmpty()) {
            view?.text_input_email_register?.error = "Field can't be empty"
            validatedEmail = false
            return false
        } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            view?.text_input_email_register?.error = "Invalid Email Format"
            return false
        } else {
            //Removes the error message if it already exists
            view?.text_input_email_register?.error = null
            view?.text_input_email_register?.isErrorEnabled = false
            validatedEmail = true
            return true
        }
    }

    //Checks to see if the entered username is okay or not.
    private fun validateUsername(): Boolean {
        //Gets the text from the username text input layout
        username = view?.text_input_username_register?.editText?.text.toString().trim()

        if (username.isEmpty()) {
            view?.text_input_username_register?.error = "Field can't be empty"
            validatedUsername = false
            return false
        } else if (username.length < 4) {
            view?.text_input_username_register?.error = "Username must be at least four characters"
            return false
        }

        //As of the current time of this else if statement, the current max characters is six.
        //Backend person said that he would change it to 12 in the future.
        else if (username.length > 12) {
            view?.text_input_username_register?.error = "Username can't be more than 12 characters"
            return false
        } else {
            //Removes the error message if it already exists
            view?.text_input_username_register?.error = null
            view?.text_input_username_register?.isErrorEnabled = false
            validatedUsername = true
            return true
        }
    }

    //Checks to see if the entered password is okay or not.
    private fun validatePassword(): Boolean {
        //Gets the text from the password text input layout
        password = view?.text_input_password_register?.editText?.text.toString().trim()

        if (password.isEmpty()) {
            view?.text_input_password_register?.error = "Field can't be empty"
            validatedPassword = false
            return false
        } else if (password.length < 4) {
            view?.text_input_password_register?.error = "Password must be at least four characters"
            return false
        } else if (password.length > 12) {
            view?.text_input_password_register?.error = "Password can't be more than 12 characters"
            return false
        } else {
            //Removes the error message if it already exists
            view?.text_input_password_register?.error = null
            view?.text_input_password_register?.isErrorEnabled = false
            validatedPassword = true
            return true
        }
    }

    fun validateAllData(): Boolean{
        return validatedFirstName && validatedLastName && validatedEmail && validatedUsername && validatedPassword
    }
}
/*

    //Checks to see if all the fields are correct or not. If so, return back to the login page.
    private fun confirmRegister() {
        //If any of the entered information isn't entered properly, prevent the user from successfully registering.
        if (!validatedFirstName || !validatedLastName || !validatedUsername || !validatedEmail || !validatedPassword)
            return

        Toast.makeText(
            this,
            "New User successfully created\nWelcome $firstName",
            Toast.LENGTH_SHORT
        ).show()
        createUserr()
        finish()
    }


    private fun createUserr(){
        val call:Call<RegisterResponse> = ServiceBuilder.create().createUser(NewUser(firstName,lastName,email,username,password))

        call.enqueue(object: Callback<RegisterResponse>{
            override fun onFailure(call: Call<RegisterResponse>, t: Throwable) {
                Log.i("OnFailure", t.message)
            }

            override fun onResponse(call: Call<RegisterResponse>, response: Response<RegisterResponse>) {
                token = response.body()!!.token
                Log.i("onRespone", token)
            }
        })
    }

*/
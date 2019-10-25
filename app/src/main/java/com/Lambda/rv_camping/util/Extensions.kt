package com.Lambda.rv_camping.util

import android.content.Context
import android.view.View
import android.widget.Toast
import com.Lambda.rv_camping.model.Properties

fun Context.toastRegister(message: String){
    Toast.makeText(this,"Welcome $message", Toast.LENGTH_SHORT).show()
}

fun Context.toast(message: String){
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}

fun View.show(){
    this.visibility = View.VISIBLE
}

fun View.gone() {
    this.visibility = View.GONE
}
fun plus(properties: MutableList<Properties>):Boolean{
    return true
}
operator fun View.minus(properties: MutableList<Properties>):Boolean{
    return true
}


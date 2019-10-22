package com.Lambda.rv_camping.util

import android.content.Context
import android.view.View
import android.widget.Toast

fun Context.toastRegister(message: String){
    Toast.makeText(this,"Welcome $message", Toast.LENGTH_SHORT).show()
}

fun View.show(){
    this.visibility = View.VISIBLE
}

fun View.gone(){
    this.visibility = View.GONE
}
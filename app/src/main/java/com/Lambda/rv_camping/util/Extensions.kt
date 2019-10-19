package com.Lambda.rv_camping.util

import android.content.Context
import android.widget.Toast

fun Context.toastRegister(message: String){
    Toast.makeText(this,"Welcome $message", Toast.LENGTH_SHORT).show()
}
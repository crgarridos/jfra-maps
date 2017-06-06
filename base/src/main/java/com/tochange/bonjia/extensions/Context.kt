package com.tochange.bonjia.extensions

import android.content.Context
import android.support.annotation.IntegerRes
import android.widget.Toast

/**
 * Created by cristian on 30/05/17
 */
fun Context.toast(message : String){
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}
fun Context.longToast(message : String){
    Toast.makeText(this, message, Toast.LENGTH_LONG).show()
}

fun Context.toast(@IntegerRes message : Int){
    Toast.makeText(this, str(message), Toast.LENGTH_SHORT).show()
}
fun Context.longToast(@IntegerRes message : Int){
    Toast.makeText(this, str(message), Toast.LENGTH_LONG).show()
}

fun Context.str(@IntegerRes strId : Int) = getString(strId)
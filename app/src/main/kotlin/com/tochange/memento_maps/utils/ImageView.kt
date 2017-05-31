package com.tochange.memento_maps.utils

import android.widget.ImageView
import com.squareup.picasso.Picasso

/**
 * Created by cristiangarrido on 30/05/2017.
 */
fun ImageView.loadUrl(url : String){
    Picasso.with(context).load(url).into(this)
}
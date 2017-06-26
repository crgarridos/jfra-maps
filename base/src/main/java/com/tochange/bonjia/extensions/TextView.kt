package com.tochange.bonjia.extensions

import android.support.annotation.StringRes
import android.support.v4.util.PatternsCompat
import android.widget.TextView
import java.util.regex.Pattern

/**
 * Created by cristian on 20/06/17
 */
fun TextView.validPattern(pattern : Pattern, error: String) : Boolean{
    if(!pattern.matcher(this.text?: "").matches()){
        this.error = error
        return false
    }
    return true
}

/**
 * Test if the content is a valid android Email address (RFC5321) {@code PatternsCompat#EMAIL_ADDRESS}
 * @param error the text to set when the pattern does not match, it uses TextView#setError method {@link android.support.v4.util.PatternsCompat#EMAIL_ADDRESS PatternsCompat.EMAIL_ADDRESS}
 * @return if email is valid
 * @see PatternsCompat.EMAIL_ADDRESS
 */
fun TextView.validEmail(error: String) : Boolean {
    return validPattern(PatternsCompat.EMAIL_ADDRESS, error)
}

/**
 * Idem as #validEmail but receiving a string resource id.
 */
fun TextView.validEmail(@StringRes errorResId: Int) : Boolean {
    return validPattern(PatternsCompat.EMAIL_ADDRESS, context.getString(errorResId))
}

fun TextView.validLength(error: String, min: Int, max: Int = 150): Boolean {
    return validPattern(Pattern.compile("^.{$min,$max}$"), error)
}


fun TextView.validLength(@StringRes errorResId: Int, min: Int, max: Int = 150): Boolean {
    return validLength(context.getString(errorResId), min, max)
}
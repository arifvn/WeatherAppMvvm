package com.squareit.weatherapp.util.extensions

import android.app.Activity
import android.util.Log
import android.view.View
import com.google.android.material.snackbar.Snackbar
import java.text.SimpleDateFormat
import java.util.*

fun Any.lok(message: Any) {
    Log.d("TAG : RESULT", "$message")
}

fun Activity.snack(root: View, message: Any) {
    Snackbar.make(root, message.toString(), Snackbar.LENGTH_SHORT)
}

fun convertTimeStampToStringDate(time: Long): String {
    return try {
        val sdf = SimpleDateFormat("dd MM yyyy", Locale.getDefault())
        val netDate = Date(time * 1000)
        sdf.format(netDate)
    } catch (e: Exception) {
        e.toString()
    }
}

fun convertTimeStampToStringTime(time: Long): String {
    return try {
        val sdf = SimpleDateFormat("hh:mm", Locale.getDefault())
        val netDate = Date(time * 1000)
        sdf.format(netDate)
    } catch (e: Exception) {
        e.toString()
    }
}

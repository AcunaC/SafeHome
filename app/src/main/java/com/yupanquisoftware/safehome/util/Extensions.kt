package com.yupanquisoftware.safehome.util

import android.content.Context
import android.widget.Toast

fun Context.showShortToast(
    context: Context = applicationContext,
    message: String,
    duration: Int = Toast.LENGTH_SHORT
) = Toast.makeText(context, message, duration).show()
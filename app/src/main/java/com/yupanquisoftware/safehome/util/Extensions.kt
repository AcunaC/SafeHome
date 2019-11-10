package com.yupanquisoftware.safehome.util

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import java.util.logging.Logger

fun Any.getLogger(): Logger = Logger.getLogger(this.javaClass.simpleName)

fun String.isNumericString(): Boolean = this.matches("[0-9]+".toRegex())

fun Context.showShortToast(
    context: Context = applicationContext,
    message: String,
    duration: Int = Toast.LENGTH_SHORT
) = Toast.makeText(context, message, duration).show()


fun <T> Activity.openActivity(it: Class<T>, finish: Boolean, extras: Bundle.() -> Unit = {}) {
    val intent = Intent(this, it)
    intent.putExtras(Bundle().apply(extras))
    startActivity(intent)
    if (finish) finish()
}

fun <T> Activity.openActivityForResult(
    it: Class<T>,
    requestCode: Int,
    extras: Bundle.() -> Unit = {}
) {
    val intent = Intent(this, it)
    intent.putExtras(Bundle().apply(extras))
    startActivityForResult(intent, requestCode)
}

fun <T> Activity.openAndFinishActivity(it: Class<T>, extras: Bundle.() -> Unit = {}) {
    val intent = Intent(this, it)
    intent.putExtras(Bundle().apply(extras))
    startActivity(intent)
    finish()
}


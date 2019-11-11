package com.yupanquisoftware.safehome.util

import android.view.View
import android.widget.EditText
import androidx.databinding.BindingAdapter


@BindingAdapter("app:onFocusChange")
fun onFocusChange(
    text: EditText,
    listener: View.OnFocusChangeListener?
) {
    text.onFocusChangeListener = listener
}

@BindingAdapter("app:onKeyPressed")
fun onKeyPressed(
    text: EditText,
    listener: View.OnKeyListener
) {
    text.setOnKeyListener(listener)
}


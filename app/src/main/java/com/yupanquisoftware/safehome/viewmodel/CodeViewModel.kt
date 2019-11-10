package com.yupanquisoftware.safehome.viewmodel

import android.text.Editable
import android.text.TextWatcher
import android.view.KeyEvent
import android.widget.TextView
import androidx.databinding.ObservableBoolean
import androidx.lifecycle.ViewModel

class CodeViewModel : ViewModel(), TextView.OnEditorActionListener, TextWatcher {

    var ultimo = 3
    var index = 0



    val isValid = ObservableBoolean(false)

    // Evento de cambio en los 3 primeros digitos
    fun onEmailChanged(text: CharSequence, start: Int = 0, before: Int = 0, count: Int = 0) {

        when (index) {
            ultimo -> {

            }
            else -> {
            }

        }
    }

    fun validateCode() {
        if (isValid.get()) {
            // decir gaa
        } else {
            // decir agg
        }

    }

    override fun onEditorAction(p0: TextView?, p1: Int, p2: KeyEvent?): Boolean {

        return true
    }

    override fun afterTextChanged(p0: Editable?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}
package com.yupanquisoftware.safehome.viewmodel

import android.view.KeyEvent
import android.view.View
import android.widget.TextView
import androidx.databinding.ObservableBoolean
import androidx.lifecycle.ViewModel
import com.google.android.material.textfield.TextInputEditText
import com.yupanquisoftware.safehome.util.getLogger

class CodeViewModel : ViewModel(), TextView.OnEditorActionListener, View.OnFocusChangeListener,
    View.OnKeyListener {


    val ultimo = 3
    var index = 0

    val isValid = ObservableBoolean(false)

    var currentView: TextInputEditText? = null

    val log = getLogger()

    // Evento de cambio de focus
    override fun onFocusChange(view: View, hasFocus: Boolean) {
        //log.info("El view ${view.tag} focus : $hasFocus")
        if (hasFocus) {
            currentView = view as TextInputEditText
            index = Integer.parseInt(view.tag.toString())
        } else {
            view.setOnKeyListener(null)
            flagDelete = true
        }
    }

    // Evento de cambio en los 3 primeros digitos
    fun onTextChanged(text: CharSequence, start: Int = 0, before: Int = 0, count: Int = 0) {
        log.info("texto:$text start:$start before:$before count:$count")
        if (text.isBlank()) {
            currentView?.setOnKeyListener(this)
            return
        }
        when (index) {
            ultimo -> {
                log.info("ultimo")
            }
            else -> {
                log.info("no es el ultimo")
                currentView?.focusSearch(View.FOCUS_RIGHT)?.requestFocus()
            }
        }
    }

    var flagDelete = true
    override fun onKey(view: View?, p1: Int, keyEvent: KeyEvent): Boolean {
        if (keyEvent.keyCode == KeyEvent.KEYCODE_DEL) {
            log.info("uy")
            if (flagDelete) {
                flagDelete = false
            } else {
                currentView?.focusSearch(View.FOCUS_LEFT)?.requestFocus()
            }
            return true
        }
        return false
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
}
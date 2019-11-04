package com.yupanquisoftware.safehome.viewmodel

import android.os.Handler
import android.util.Patterns
import android.view.KeyEvent
import android.widget.TextView
import androidx.databinding.ObservableBoolean
import androidx.databinding.ObservableField

class LoginViewModel : BaseViewModel(), TextView.OnEditorActionListener {

    // Entrada del usuario
    val loginEmail = ObservableField<String>()
    val rememberSession = ObservableBoolean()

    // Estado de la interfaz
    val isValidEmail = ObservableBoolean(false)
    val isLoading = ObservableBoolean(false)

    // Simulacion
    fun loginClic() {
        isLoading.set(true)
        Handler().postDelayed(Runnable {
            isLoading.set(false)
        }, 2000)
    }

    // Evento enter del teclado
    override fun onEditorAction(p0: TextView?, p1: Int, p2: KeyEvent?): Boolean {
        loginClic()
        return false
    }

    // Evento de cambio de email
    fun onEmailChanged(text: CharSequence, start: Int = 0, before: Int = 0, count: Int = 0) =
        isValidEmail.set(Patterns.EMAIL_ADDRESS.matcher(text.toString()).matches())

}
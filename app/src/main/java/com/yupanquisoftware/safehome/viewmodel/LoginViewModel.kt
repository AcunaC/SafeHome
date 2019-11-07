package com.yupanquisoftware.safehome.viewmodel

import android.os.Handler
import android.util.Patterns
import android.view.KeyEvent
import android.widget.TextView
import androidx.databinding.ObservableBoolean
import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData
import com.yupanquisoftware.safehome.R
import com.yupanquisoftware.safehome.util.LoginEnum

class LoginViewModel : BaseViewModel(), TextView.OnEditorActionListener {

    // Comunicacion con la vista
    val navAction = MutableLiveData<LoginEnum>()
    val helperMessage = MutableLiveData<Int>()
    val errorMessage = MutableLiveData<Int>()

    // Entrada del usuario
    val loginEmail = ObservableField<String>()
    val rememberSession = ObservableBoolean()

    // Estado de la interfaz
    val isValidEmail = ObservableBoolean(false)
    val isLoading = ObservableBoolean(false)

    // Simulacion
    fun loginClic() {
        errorMessage.value = null
        isLoading.set(true)
        Handler().postDelayed({
            if (loginEmail.get().equals("billykentac@gmail.com")) {
                // Guardar sesion


                //navAction.value =
                //    if (rememberSession.get()) LoginEnum.FIRST_TIME else LoginEnum.NOT_FIRST_TIME


            } else {
                errorMessage.value = R.string.unregistered_email
            }
            isLoading.set(false)
        }, 2000)
    }

    // Evento enter del teclado
    override fun onEditorAction(p0: TextView?, p1: Int, p2: KeyEvent?): Boolean {
        return if (isValidEmail.get()) {
            loginClic()
            false
        } else {
            helperMessage.value = R.string.must_be_valid_email
            true
        }
    }

    // Evento de cambio de email
    fun onEmailChanged(text: CharSequence, start: Int = 0, before: Int = 0, count: Int = 0) {
        isValidEmail.set(Patterns.EMAIL_ADDRESS.matcher(text.toString()).matches())
        if (isValidEmail.get()) {
            helperMessage.value = null
        }
    }
}
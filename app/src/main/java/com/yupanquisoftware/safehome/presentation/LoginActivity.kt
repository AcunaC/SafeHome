package com.yupanquisoftware.safehome.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.yupanquisoftware.safehome.R
import com.yupanquisoftware.safehome.databinding.ActivityLoginBinding
import com.yupanquisoftware.safehome.util.LoginEnum
import com.yupanquisoftware.safehome.util.openActivity
import com.yupanquisoftware.safehome.util.showShortToast
import com.yupanquisoftware.safehome.viewmodel.LoginViewModel
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private lateinit var viewmodel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewmodel = ViewModelProvider(this).get(LoginViewModel::class.java)
        binding = DataBindingUtil.setContentView(
            this,
            R.layout.activity_login
        )
        binding.viewModel = viewmodel

        observeViewModel()
    }

    private fun observeViewModel() {

        viewmodel.toastMessage.observe(this, Observer {
            showShortToast(message = it)
        })

        viewmodel.navAction.observe(this, Observer {
            when (it) {
                LoginEnum.FIRST_TIME -> {
                    openActivity(IntroActivity::class.java, true)
                }
                LoginEnum.NOT_FIRST_TIME -> {
                    openActivity(ValidateCodeActivity::class.java, true){
                        putString("message","Para iniciar sesión ingrese su PIN de seguridad.")
                    }
                }
            }
        })

        viewmodel.errorMessage.observe(this, Observer {
            if (it == null) {
                emailInputLayout.isErrorEnabled = false
            } else {
                emailInputLayout.error = getString(it)
            }
        })


        viewmodel.helperMessage.observe(this, Observer {
            if (it == null) {
                emailInputLayout.isHelperTextEnabled = false
            } else {
                emailInputLayout.helperText = getString(it)
            }
        })

    }
}

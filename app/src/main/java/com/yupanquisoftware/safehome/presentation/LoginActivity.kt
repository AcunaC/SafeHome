package com.yupanquisoftware.safehome.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.yupanquisoftware.safehome.R
import com.yupanquisoftware.safehome.databinding.ActivityLoginBinding
import com.yupanquisoftware.safehome.util.showShortToast
import com.yupanquisoftware.safehome.viewmodel.LoginViewModel
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    lateinit var binding: ActivityLoginBinding
    lateinit var viewmodel: LoginViewModel

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

    }
}

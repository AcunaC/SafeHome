package com.yupanquisoftware.safehome.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.yupanquisoftware.safehome.R
import com.yupanquisoftware.safehome.databinding.ActivityValidateCodeBinding
import com.yupanquisoftware.safehome.viewmodel.CodeViewModel

class ValidateCodeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityValidateCodeBinding
    private lateinit var viewModel: CodeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this).get(CodeViewModel::class.java)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_validate_code)
        binding.viewModel = viewModel


    }
}

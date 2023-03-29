package com.assignment.eshop.ui.auth.login

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.assignment.eshop.R
import com.assignment.eshop.base.BaseBindingFragment
import com.assignment.eshop.databinding.FragmentLoginBinding
import com.assignment.eshop.lisner.LoginListner
import com.assignment.eshop.ui.auth.login.LoginViewModel

import com.assignment.eshop.utils.Coroutines
import com.assignment.eshop.utils.toast
import javax.inject.Inject


class LoginFragment : BaseBindingFragment<FragmentLoginBinding>(), LoginListner {

    override fun layoutId(): Int = R.layout.fragment_login

    @Inject
    lateinit var viewModel: LoginViewModel
    private var navController: NavController? = null

    override fun initializeBinding(binding: FragmentLoginBinding) {
        binding.viewmodel = viewModel
        binding.lifecycleOwner = this
        binding.listner = this
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = view.findNavController()

    }


}



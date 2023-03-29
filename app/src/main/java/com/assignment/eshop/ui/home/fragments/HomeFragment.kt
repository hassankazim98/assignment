package com.assignment.eshop.ui.home.fragments

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.assignment.eshop.R
import com.assignment.eshop.base.BaseBindingFragment
import com.assignment.eshop.data.db.model.ProductListModel
import com.assignment.eshop.databinding.FragmentHomeBinding
import com.assignment.eshop.lisner.HomeListner
import com.assignment.eshop.utils.Constant
import com.assignment.eshop.utils.LogM
import com.assignment.eshop.utils.toast
import java.util.ArrayList
import javax.inject.Inject

class HomeFragment : BaseBindingFragment<FragmentHomeBinding>(), HomeListner {

    override fun layoutId(): Int = R.layout.fragment_home

    @Inject
    lateinit var viewModel: HomeViewModel
    private var binding: FragmentHomeBinding? = null

    private var navController: NavController? = null

    var strSearchData = ""

    override fun initializeBinding(binding: FragmentHomeBinding) {
        this.binding = binding
        binding.lifecycleOwner = this
        binding.viewmodel = viewModel
        binding.lifecycleOwner = this
        binding.listner = this
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = view.findNavController()
        viewModel.onMessageError.observe(viewLifecycleOwner, onMessageErrorObserver)
        LogM.e("==>data "+viewModel.product.value?.strCategory.toString())

    }


    private val onMessageErrorObserver = Observer<Any> {
        activity?.toast(it.toString())
    }

    override fun openProductDetails(model: ProductListModel) {
        val action =
            HomeFragmentDirections.actionNavigationHomeToProductDetailsFragment(model.idMeal.toString())
        navController?.navigate(action)
    }
    fun openSearchScreen() {
        if (strSearchData.length > 0) {
            val action = HomeFragmentDirections.actionGlobalSearchFragment(strSearchData, Constant.kEY_FROM_SEARCH)
            navController?.navigate(action)
        }
    }
}
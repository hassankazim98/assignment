package com.assignment.eshop.ui.productdetail

import android.os.Bundle
import android.view.View
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import com.assignment.eshop.R
import com.assignment.eshop.base.BaseBindingFragment
import com.assignment.eshop.databinding.FragmentProductDetailsBinding
import com.assignment.eshop.utils.Constant
import com.assignment.eshop.utils.toast
import javax.inject.Inject


class ProductDetailsFragment : BaseBindingFragment<FragmentProductDetailsBinding>(){
    @Inject
    lateinit var viewmodel: ProductDetailsViewModel
    private var binding: FragmentProductDetailsBinding? = null

    override fun layoutId(): Int = R.layout.fragment_product_details

    private val args: ProductDetailsFragmentArgs by navArgs()

    private var navController: NavController? = null
    private var productId = ""

    override fun initializeBinding(binding: FragmentProductDetailsBinding) {
        this.binding = binding
        binding.lifecycleOwner = this
        binding.viewmodel = viewmodel
        binding.lifecycleOwner = this
        binding.listner = this
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = view.findNavController()
        productId = args.productid


        if (globalMethods.isInternetAvailable(requireActivity())) {
            viewmodel.callProductDetails(productId)

        } else {
            requireActivity().toast(Constant.CHECK_INTERNET)
        }

    }

    }



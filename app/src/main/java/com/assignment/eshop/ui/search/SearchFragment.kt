package com.assignment.eshop.ui.search

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import com.assignment.eshop.R
import com.assignment.eshop.base.BaseBindingFragment
import com.assignment.eshop.databinding.FragmentSearchBinding
import com.assignment.eshop.utils.Constant
import com.assignment.eshop.utils.toast
import javax.inject.Inject


class SearchFragment : BaseBindingFragment<FragmentSearchBinding>(){

    override fun layoutId(): Int = R.layout.fragment_search

    @Inject
    lateinit var viewModel: SearchViewModel
    private var binding: FragmentSearchBinding? = null

    private val args: SearchFragmentArgs by navArgs()
    private var navController: NavController? = null

    var searchData = ""
    private lateinit var title: TextView

    override fun initializeBinding(binding: FragmentSearchBinding) {
        this.binding = binding
        binding.viewmodel = viewModel
        binding.lifecycleOwner = this
        binding.listner = this
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        title = view.findViewById(R.id.title)
        navController = view.findNavController()
        searchData = args.searchData
        viewModel.onMessageError.observe(viewLifecycleOwner, onMessageErrorObserver)

        viewModel.setSearchData(searchData)

        //if searchData is null the call Wish list otherwise call search list data.
        if(searchData.length == 0) {
            title.text = view.resources.getString(R.string.shopping_list)

        } else {
            title.text = view.resources.getString(R.string.search_result)
            makeAPIcall()
        }
    }

    private val onMessageErrorObserver = Observer<Any> {
        activity?.toast(it.toString())
    }

    fun makeAPIcall() {
        if(globalMethods.isInternetAvailable(requireActivity())) {
            if(searchData.length > 0) {
                viewModel.callSearch(searchData)
            }
        } else {
            requireActivity().toast(Constant.CHECK_INTERNET)
        }
    }

    /*override fun openProductDetails(model: SearchModel.Data) {
        val action = SearchFragmentDirections.actionSearchFragmentToProductDetailsFragment(model.productid)
        navController?.navigate(action)
    }*/
}
package com.assignment.eshop.binding

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.assignment.eshop.data.db.model.AllProductModel
import com.assignment.eshop.data.db.model.Product
import com.assignment.eshop.data.db.model.ProductListModel
import com.assignment.eshop.ui.home.fragments.HomeFragment
import com.assignment.eshop.ui.home.fragments.adpter.ProductListAdapter

@BindingAdapter("bindAllProductList", "bindHomeListner")
fun bindAllProductList(view: RecyclerView, list: List<Product.Meal>?, fragment: HomeFragment?) {
    if(list != null) {
        var adapter = view.adapter
        adapter = ProductListAdapter(view.context, list,fragment!!)
        view.adapter = adapter

    }
}
/*
//Comma seperated string
@BindingAdapter("loadProductListImage")
fun loadProductListImage(view: ImageView, url: String?) {
    if(url != null) {
        val arr = url?.split(",")
        view.loadUrl(arr?.get(0)!!)
    }
}

@BindingAdapter("loadImageFromUrl")
fun loadImageFromUrl(view: ImageView, url: String?) {
    if(url != null) {
        view.loadUrl(url!!)
    }
}*/

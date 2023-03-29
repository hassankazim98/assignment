package com.assignment.eshop.ui.home.fragments.adpter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.assignment.eshop.data.db.model.ProductListModel
import com.assignment.eshop.databinding.AdapterProductListBinding
import com.assignment.eshop.lisner.HomeListner
import com.assignment.eshop.BR

class ProductListAdapter(
    private val context: Context,
    private val dataList: List<ProductListModel>,
    private val listner: HomeListner
) : RecyclerView.Adapter<ProductListAdapter.BindingViewHolder>() {

    override fun getItemCount() = dataList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BindingViewHolder {
        val rootView: ViewDataBinding =
            AdapterProductListBinding.inflate(LayoutInflater.from(context), parent, false)
        return BindingViewHolder(
            rootView
        )
    }

    override fun onBindViewHolder(holder: BindingViewHolder, position: Int) {
        val model = dataList[position]
        holder.itemBinding.setVariable(BR.productList, model)
        holder.itemBinding.executePendingBindings()
        holder.itemBinding.setVariable(BR.homeListner, listner)
    }

    class BindingViewHolder(val itemBinding: ViewDataBinding) :
        RecyclerView.ViewHolder(itemBinding.root)
}
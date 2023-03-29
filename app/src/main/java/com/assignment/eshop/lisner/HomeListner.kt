package com.assignment.eshop.lisner

import com.assignment.eshop.data.db.model.ProductListModel


interface HomeListner {
    fun openProductDetails(model : ProductListModel)
}
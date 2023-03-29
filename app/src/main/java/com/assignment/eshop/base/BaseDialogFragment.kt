package com.assignment.eshop.base

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.CallSuper
import androidx.lifecycle.ViewModelProvider
import com.assignment.eshop.di.Injectable
import com.assignment.eshop.utils.GlobalMethods
import com.assignment.eshop.utils.NavigationController
import com.assignment.eshop.utils.PrefUtils
import com.assignment.eshop.utils.inflate
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import javax.inject.Inject

abstract class BaseDialogFragment: BottomSheetDialogFragment(), Injectable {

    /**
     * Object for @see [ViewModelProvider.Factory]
     * */
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    /**
     * Object for @see [PrefUtils] for preferences storage
     * */
    @Inject
    lateinit var prefUtils: PrefUtils
    /**
     * Object for @see [NavigationController], which is used to for navigating screens
     * */
    @Inject
    lateinit var navigationController: NavigationController

    /**
     * Makeing GlobalMethods injecatable
     * */
    @Inject
    lateinit var globalMethods: GlobalMethods

    /**
     * This function will @return layoutId i.e. R.layout.something
     * */
    abstract fun layoutId(): Int

    /**
     * To get [BaseActivity] INSTANCE
     */
    fun getBaseActivity(): BaseActivity? {
        return activity as? BaseActivity
    }

    /**
     * One of the fragment life cycle methods, gets called when fragment gets created
     * */
    @CallSuper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        retainInstance = true
        setHasOptionsMenu(true)
    }

    /**
     * One of the fragment life cycle methods, gets called when fragment's view gets created
     * */
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return container?.inflate(layoutId())
    }

    /**
     * for setting actionBarIcon
     * @param drawable -> drawable resource file which needs to be set as an Icon of actionBar
     * */
    fun setActionBarIcon(drawable: Drawable?) {
        getBaseActivity()?.supportActionBar?.setIcon(drawable)
    }

    /**
     * title of actionBar
     * @param title -> text of string which will be set as a title of actionBar
     * */
    fun setTitle(title: String) {
        getBaseActivity()?.supportActionBar?.title = title
    }

    /**
     * subTitle of actionBar
     * @param subTitle -> text of string which will be set as a subTitle of actionBar
     * */
    fun setSubTitle(subTitle: String) {
        getBaseActivity()?.supportActionBar?.subtitle = subTitle
    }
}
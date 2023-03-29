package com.assignment.eshop.di

import com.assignment.eshop.ui.auth.LoginActivity
import com.assignment.eshop.ui.home.HomeActivity
import com.assignment.eshop.ui.home.fragments.HomeFragment
import com.assignment.eshop.ui.productdetail.ProductDetailsFragment
import com.assignment.eshop.ui.search.SearchFragment
import com.assignment.eshop.ui.splash.SplashActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Helps to generate an {@link AndroidInjector} for all activities
 * */
@Suppress("unused")
@Module
abstract class ActivityBuilder {

    /**
     * fun to bind  SplashActivity, making Injection enable
     **/
    @ContributesAndroidInjector()
    abstract fun bindSplashActivity() : SplashActivity
    /**
     * fun to bind  LoginActivity, making Injection enable
     **/
    @ContributesAndroidInjector()
    abstract fun bindLoginActivity() : LoginActivity

    /**
     * fun to bind Home Activity, making Injection enable
     **/
    @ContributesAndroidInjector()
    abstract fun bindHomeActivity() : HomeActivity


    /**
     * fun to bind Home Fragment, making Injection enable
     **/
    @ContributesAndroidInjector()
    abstract fun bindHomeFragment() : HomeFragment
    /**
     * fun to bind ProductDetails Fragment, making Injection enable
     **/
    @ContributesAndroidInjector()
    abstract fun ProductDetailsFragment() : ProductDetailsFragment

    /**
     * fun to bind SearchFragment  , making Injection enable
     **/
    @ContributesAndroidInjector()
    abstract fun SearchFragment () : SearchFragment

}
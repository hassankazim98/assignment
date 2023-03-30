package com.assignment.eshop

import android.app.Application
import androidx.appcompat.app.AppCompatDelegate
import com.assignment.eshop.api.RetrofitHelper
import com.assignment.eshop.api.WebServiceInterface
import com.assignment.eshop.data.repository.HomeRepository
import com.assignment.eshop.di.AppInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

class MyApp  : Application(), HasAndroidInjector {

    lateinit var homeRepository: HomeRepository
    /**
     * @see [dagger.android.DispatchingAndroidInjector]
     * */
    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Any>

    /**
     * @see [dagger.android.DispatchingAndroidInjector]
     * */
    override fun androidInjector() = dispatchingAndroidInjector

    /**
     * this method gets called when the Application gets created
     * */
    override fun onCreate() {
        super.onCreate()
        AppInjector.init(this)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        initialize()
    }
    private fun initialize() {
        val apiService = RetrofitHelper.getInstance().create(WebServiceInterface::class.java)
        homeRepository = HomeRepository(apiService)
    }
}
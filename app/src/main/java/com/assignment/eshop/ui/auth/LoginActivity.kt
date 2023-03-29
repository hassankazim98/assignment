package com.assignment.eshop.ui.auth

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.RelativeLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import com.assignment.eshop.R
import com.assignment.eshop.base.BaseActivity
import com.assignment.eshop.di.Injectable
import com.assignment.eshop.utils.toast
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

class LoginActivity : BaseActivity() {

    override fun layoutId() = R.layout.activity_login

    private lateinit var navController: NavController
    private lateinit var linerfbCart: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        linerfbCart = findViewById(R.id.linearlayoutFb)
        setListner()

    }

    private fun setListner() {
        linerfbCart.setOnClickListener() {
            /*val action = HomeFragmentDirections.actionGlobalCartFragment2()
            navController.navigate(action)*/
        }

    }
}


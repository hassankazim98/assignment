package com.assignment.eshop.ui.splash

import android.content.Intent
import android.os.Bundle
import com.assignment.eshop.R
import com.assignment.eshop.base.BaseActivity
import com.assignment.eshop.ui.auth.LoginActivity
import com.assignment.eshop.ui.home.HomeActivity
import com.assignment.eshop.utils.clearStack

class SplashActivity : BaseActivity() {
    override fun layoutId() = R.layout.activity_splash

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val homeIntent = Intent(this@SplashActivity, HomeActivity::class.java)
        homeIntent.clearStack()
        startActivity(homeIntent)
        this.overridePendingTransition(0, 0)
    }
}
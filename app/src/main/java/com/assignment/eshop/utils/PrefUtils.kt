package com.assignment.eshop.utils

import android.content.Context
import android.content.SharedPreferences
import javax.inject.Inject

/**
 * Handles Shared Preferences through out the App
 */
@Suppress("unused")
class PrefUtils @Inject constructor(context: Context) {
    /**
     * Object of [android.content.SharedPreferences]
     * */
    private val appPreference = context.getSharedPreferences(Constant.APP_PREFERENCES, Context.MODE_PRIVATE)
//    private val hintVideoPreference = context.getSharedPreferences(Constant.HINT_VIDEO_PREFERENCE, Context.MODE_PRIVATE)

}
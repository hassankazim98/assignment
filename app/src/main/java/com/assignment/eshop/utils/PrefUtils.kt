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


    private val SAVE_USER_DATA = "saveUserData"
    private val USER_ID = "user_id"
    private val IS_HINT_VIDEO_PLAYED = "is_hint_video_played"
    private val SELECTED_LANGUAGE_POSITION = "selected_language_position"

    fun saveUserId(custId : String){
        val editor: SharedPreferences.Editor = appPreference.edit()
        editor.putString(USER_ID, custId)
        editor.apply()
    }

    fun getUserId() : String?{
        return appPreference.getString(USER_ID, null)
    }

    fun setSelectedLanguage(position: Int) {
        val editor: SharedPreferences.Editor = appPreference.edit()
        editor.putInt(SELECTED_LANGUAGE_POSITION, position)
        editor.apply()
    }

    fun getSelectedLanguage() : Int{
        return appPreference.getInt(SELECTED_LANGUAGE_POSITION, 0)
    }

//    fun isHintVideoPlayed() : Boolean{
//        return hintVideoPreference.getBoolean(IS_HINT_VIDEO_PLAYED, false)
//    }
//
//    fun setHintVideoPlayed(isPlayed: Boolean) {
//        val editor: SharedPreferences.Editor = hintVideoPreference.edit()
//        editor.putBoolean(IS_HINT_VIDEO_PLAYED, isPlayed)
//        editor.apply()
//    }

    /**
     * Method to clear All Stored Preferences
     */
    fun clearAll() {
        val mEditor = appPreference.edit()
        mEditor.clear()
        mEditor.apply()
    }

}
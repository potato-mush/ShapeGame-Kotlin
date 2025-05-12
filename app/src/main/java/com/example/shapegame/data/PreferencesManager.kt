package com.example.shapegame.data

import android.content.Context
import android.content.SharedPreferences

class PreferencesManager(context: Context) {
    private val sharedPreferences: SharedPreferences = 
        context.getSharedPreferences("game_preferences", Context.MODE_PRIVATE)

    fun saveVolume(volume: Float) {
        sharedPreferences.edit().putFloat(VOLUME_KEY, volume).apply()
    }

    fun getVolume(): Float {
        return sharedPreferences.getFloat(VOLUME_KEY, 0.5f)
    }

    companion object {
        private const val VOLUME_KEY = "volume"
    }
}

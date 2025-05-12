package com.example.shapegame.audio

import android.content.Context
import android.media.MediaPlayer
import com.example.shapegame.R
import com.example.shapegame.data.PreferencesManager

class SoundManager(private val context: Context) {
    private var gameMusic: MediaPlayer? = null
    private var correctSound: MediaPlayer? = null
    private var wrongSound: MediaPlayer? = null
    private var resultSound: MediaPlayer? = null
    private val preferencesManager = PreferencesManager(context)

    init {
        initializeSounds()
    }

    private fun initializeSounds() {
        gameMusic = MediaPlayer.create(context, R.raw.gamesound).apply {
            isLooping = true
            val volume = preferencesManager.getVolume()
            setVolume(volume, volume)
        }
        correctSound = MediaPlayer.create(context, R.raw.correct)
        wrongSound = MediaPlayer.create(context, R.raw.wrong)
        resultSound = MediaPlayer.create(context, R.raw.resultsound)
        updateVolume()
    }

    fun updateVolume() {
        val volume = preferencesManager.getVolume()
        gameMusic?.setVolume(volume, volume)
        correctSound?.setVolume(volume, volume)
        wrongSound?.setVolume(volume, volume)
        resultSound?.setVolume(volume, volume)
    }

    private fun playSoundEffect(mediaPlayer: MediaPlayer?) {
        mediaPlayer?.apply {
            val volume = preferencesManager.getVolume()
            setVolume(volume, volume)
            if (isPlaying) {
                seekTo(0)
            }
            start()
        }
    }

    fun startGameMusic() {
        try {
            gameMusic?.apply {
                val volume = preferencesManager.getVolume()
                setVolume(volume, volume)
                if (!isPlaying) start()
            }
        } catch (e: IllegalStateException) {
            // Recreate and restart the media player if it's in an error state
            gameMusic?.release()
            gameMusic = MediaPlayer.create(context, R.raw.gamesound).apply {
                isLooping = true
                val volume = preferencesManager.getVolume()
                setVolume(volume, volume)
                start()
            }
        }
    }

    fun stopGameMusic() {
        gameMusic?.apply {
            if (isPlaying) {
                pause()
                seekTo(0)
            }
        }
    }

    fun playCorrectSound() {
        playSoundEffect(correctSound)
    }

    fun playWrongSound() {
        playSoundEffect(wrongSound)
    }

    fun playResultSound() {
        playSoundEffect(resultSound)
    }

    fun release() {
        gameMusic?.release()
        correctSound?.release()
        wrongSound?.release()
        resultSound?.release()
        gameMusic = null
        correctSound = null
        wrongSound = null
        resultSound = null
    }
}

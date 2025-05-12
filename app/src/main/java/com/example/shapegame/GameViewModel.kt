package com.example.shapegame

import android.content.Context
import androidx.lifecycle.ViewModel
import com.example.shapegame.audio.SoundManager

class GameViewModel : ViewModel() {
    private var level = 1
    private var questionIndex = 0
    var score = 0
        private set

    private var shuffledQuestions: List<ShapeQuestion> = emptyList()
    private var soundManager: SoundManager? = null

    private val grade1Questions = listOf(
        ShapeQuestion(R.drawable.square, "Square", listOf("Circle", "Triangle", "Star")),
        ShapeQuestion(R.drawable.circle, "Circle", listOf("Square", "Rectangle", "Star")),
        ShapeQuestion(R.drawable.triangle, "Triangle", listOf("Circle", "Square", "Rectangle")),
        ShapeQuestion(R.drawable.rectangle, "Rectangle", listOf("Triangle", "Circle", "Star")),
        ShapeQuestion(R.drawable.star, "Star", listOf("Square", "Circle", "Triangle"))
    )

    private val grade2Questions = grade1Questions + listOf(
        ShapeQuestion(R.drawable.oval, "Oval", listOf("Circle", "Diamond", "Hexagon")),
        ShapeQuestion(R.drawable.diamond, "Diamond", listOf("Oval", "Hexagon", "Rectangle")),
        ShapeQuestion(R.drawable.hexagon, "Hexagon", listOf("Diamond", "Oval", "Circle"))
    )

    private val grade3Questions = grade2Questions + listOf(
        ShapeQuestion(R.drawable.cone, "Cone", listOf("Cube", "Sphere", "Cylinder")),
        ShapeQuestion(R.drawable.cube, "Cube", listOf("Cone", "Sphere", "Cylinder")),
        ShapeQuestion(R.drawable.sphere, "Sphere", listOf("Cube", "Cone", "Cylinder")),
        ShapeQuestion(R.drawable.cylinder, "Cylinder", listOf("Sphere", "Cube", "Cone")),
        ShapeQuestion(R.drawable.pentagon, "Pentagon", listOf("Hexagon", "Octagon", "Diamond")),
        ShapeQuestion(R.drawable.octagon, "Octagon", listOf("Pentagon", "Hexagon", "Diamond"))
    )

    private val questions: List<ShapeQuestion>
        get() = shuffledQuestions

    fun setLevel(level: Int) {
        this.level = level
        resetGame()
    }

    fun getCurrentQuestion(): ShapeQuestion? {
        return if (questionIndex < questions.size) questions[questionIndex] else null
    }

    fun submitAnswer(answer: String) {
        val currentQuestion = getCurrentQuestion() ?: return
        if (answer == currentQuestion.correctAnswer) {
            score++
            soundManager?.playCorrectSound()
        } else {
            soundManager?.playWrongSound()
        }
    }

    fun moveToNextQuestion() {
        questionIndex++
    }

    fun isQuizFinished(): Boolean {
        return when (level) {
            1 -> questionIndex >= 4
            2 -> questionIndex >= 5
            3 -> questionIndex >= 7
            else -> questionIndex >= 4
        }
    }

    fun resetGame() {
        questionIndex = 0
        score = 0
        shuffledQuestions = when (level) {
            1 -> grade1Questions.shuffled().take(4)
            2 -> grade2Questions.shuffled().take(5)
            3 -> grade3Questions.shuffled().take(7)
            else -> grade1Questions.shuffled().take(4)
        }
    }

    fun getTotalQuestions(): Int {
        return questions.size
    }

    fun initializeSoundManager(context: Context) {
        soundManager = SoundManager(context)
    }

    fun startQuizMusic() {
        soundManager?.startGameMusic()
    }

    fun stopQuizMusic() {
        soundManager?.stopGameMusic()
    }

    fun playResultSound() {
        soundManager?.playResultSound()
    }

    fun startGameMusic() {
        soundManager?.startGameMusic()
    }

    fun stopGameMusic() {
        soundManager?.stopGameMusic()
    }

    fun onScreenExit() {
        stopGameMusic()
    }

    override fun onCleared() {
        super.onCleared()
        stopGameMusic()
        soundManager?.release()
    }
}

data class ShapeQuestion(
    val imageResId: Int,
    val correctAnswer: String,
    val incorrectAnswers: List<String>
) {
    private var _options: List<String>? = null
    
    val options: List<String>
        get() {
            if (_options == null) {
                _options = (listOf(correctAnswer) + incorrectAnswers).shuffled()
            }
            return _options!!
        }

    fun resetOptions() {
        _options = null
    }
}

// Verify that all drawable resources (e.g., R.drawable.square, R.drawable.circle) exist in the res/drawable folder.
// If any resource is missing, add a placeholder image or remove the reference to avoid errors.


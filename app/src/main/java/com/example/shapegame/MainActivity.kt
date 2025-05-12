package com.example.shapegame

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.*
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.shapegame.screens.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val gameViewModel: GameViewModel = viewModel()
            
            // Initialize sound manager
            LaunchedEffect(Unit) {
                gameViewModel.initializeSoundManager(this@MainActivity)
            }

            var currentScreen by remember { mutableStateOf("MainMenu") }

            // Handle music state changes
            LaunchedEffect(currentScreen) {
                when (currentScreen) {
                    "Result" -> {
                        gameViewModel.stopGameMusic()
                        gameViewModel.playResultSound()
                    }
                    else -> gameViewModel.startGameMusic()
                }
            }

            when (currentScreen) {
                "MainMenu" -> MainMenuScreen(
                    onStartQuiz = {
                        gameViewModel.resetGame()
                        currentScreen = "Quiz"
                    },
                    onSettings = { currentScreen = "Settings" },
                    onLevels = { currentScreen = "Levels" }
                )
                "Quiz" -> QuizScreen(
                    gameViewModel = gameViewModel,
                    onQuizEnd = { currentScreen = "Result" },
                    onPause = { currentScreen = "Pause" }
                )
                "Pause" -> PauseScreen(
                    onResume = { currentScreen = "Quiz" },
                    onReset = {
                        gameViewModel.resetGame()
                        currentScreen = "Quiz"
                    },
                    onMainMenu = { currentScreen = "MainMenu" }
                )
                "Result" -> ResultScreen(
                    score = gameViewModel.score,
                    totalQuestions = gameViewModel.getTotalQuestions(),
                    onReturnToMenu = { currentScreen = "MainMenu" }
                )
                "Levels" -> LevelsScreen(
                    onLevelSelected = { level ->
                        gameViewModel.setLevel(level)
                        currentScreen = "MainMenu"
                    }
                )
                "Settings" -> SettingsScreen(
                    onReturnToMenu = { currentScreen = "MainMenu" }
                )
            }
        }
    }
}

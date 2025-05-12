package com.example.shapegame.screens

import androidx.compose.foundation.Image
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.shapegame.GameViewModel
import com.example.shapegame.R

@Composable
fun QuizScreen(gameViewModel: GameViewModel, onQuizEnd: () -> Unit, onPause: () -> Unit) {
    var reloadKey by remember { mutableStateOf(0) }
    val question = gameViewModel.getCurrentQuestion()
    var selectedAnswer by remember { mutableStateOf<String?>(null) }
    var showNextButton by remember { mutableStateOf(false) }
    var isCorrect by remember { mutableStateOf(false) }

    if (question == null) {
        onQuizEnd()
        return
    }

    LaunchedEffect(reloadKey) {
        selectedAnswer = null
        showNextButton = false
        question.resetOptions() // Reset options when moving to next question
    }

    Scaffold(
        topBar = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(color = Color(0xFF1A88EF)),
                horizontalArrangement = Arrangement.Start
            ) {
                IconButton(
                    onClick = onPause,
                    modifier = Modifier.size(48.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.pause),
                        contentDescription = "Pause",
                        modifier = Modifier.size(32.dp)
                    )
                }
            }
        },
        modifier = Modifier.fillMaxSize()
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .background(color = Color(0xFF1A88EF)),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Shape image alone
            key(reloadKey) {
                Image(
                    painter = painterResource(id = question.imageResId),
                    contentDescription = "Shape Image",
                    modifier = Modifier.size(200.dp)
                )
            }

            Spacer(modifier = Modifier.height(24.dp))

            // Question mark and text
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier.padding(horizontal = 16.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.question),
                    contentDescription = "Question Mark",
                    modifier = Modifier.size(64.dp)
                )
                Text(
                    "What is this shape?",
                    color = Color.White,
                    fontSize = 16.sp,
                    fontFamily = FontFamily(Font(R.font.press_start_2p_regular)),
                )
            }

            Spacer(modifier = Modifier.height(32.dp))

            // Choices section
            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(8.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                question.options.chunked(2).forEach { row ->
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {
                        row.forEach { option ->
                            val buttonColor = when {
                                selectedAnswer == option && option == question.correctAnswer -> Color(0xFF00C853) // Green for correct
                                selectedAnswer == option -> Color(0xFFD32F2F) // Red for wrong
                                else -> Color(0xFF45E1E1) // Default color
                            }

                            Button(
                                onClick = {
                                    if (selectedAnswer == null) {
                                        selectedAnswer = option
                                        isCorrect = option == question.correctAnswer
                                        gameViewModel.submitAnswer(option)
                                        showNextButton = true
                                    }
                                },
                                modifier = Modifier
                                    .padding(horizontal = 8.dp)
                                    .weight(1f),
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = buttonColor,
                                    disabledContainerColor = buttonColor // Keep color when disabled
                                ),
                                enabled = selectedAnswer == null
                            ) {
                                Text(
                                    option,
                                    fontSize = 20.sp,
                                    color = Color.White
                                )
                            }
                        }
                    }
                }
            }
            Spacer(modifier = Modifier.height(16.dp))
            if (showNextButton) {
                Button(
                    onClick = {
                        if (gameViewModel.isQuizFinished()) {
                            onQuizEnd()
                        } else {
                            gameViewModel.moveToNextQuestion()
                            reloadKey++
                        }
                    },
                    modifier = Modifier.padding(horizontal = 16.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF45E1E1)),
                ) {
                    Text(if (gameViewModel.isQuizFinished()) "Finish" else "Next", fontSize = 20.sp)
                }
            }
        }
    }
}

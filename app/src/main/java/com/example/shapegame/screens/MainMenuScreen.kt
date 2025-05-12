package com.example.shapegame.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.shapegame.R

@Composable
fun MainMenuScreen(onStartQuiz: () -> Unit, onSettings: () -> Unit, onLevels: () -> Unit) {
    val pixelFont = FontFamily(Font(R.font.press_start_2p_regular))

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xFF1A88EF))
    ) {
        AnimatedShapes(screenState = "MainMenu")

        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        "SHAPE GAME",
                        style = TextStyle(
                            fontSize = 40.sp,
                            letterSpacing = 4.sp,
                            fontWeight = FontWeight.Bold,
                            fontFamily = pixelFont,
                            textAlign = androidx.compose.ui.text.style.TextAlign.Center
                        ),
                        color = Color.Black
                    )
                }
                Spacer(modifier = Modifier.height(80.dp))

                Button(
                    onClick = onStartQuiz,
                    modifier = Modifier
                        .width(300.dp)
                        .height(80.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF45E1E1))
                ) {
                    Text(
                        "Play",
                        fontSize = 24.sp,
                        letterSpacing = 3.sp,
                        fontWeight = FontWeight.Bold,
                        fontFamily = pixelFont
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))

                Button(
                    onClick = onLevels,
                    modifier = Modifier
                        .width(300.dp)
                        .height(80.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF45E1E1))
                ) {
                    Text(
                        "Levels",
                        fontSize = 24.sp,
                        letterSpacing = 3.sp,
                        fontWeight = FontWeight.Bold,
                        fontFamily = pixelFont
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))

                Button(
                    onClick = onSettings,
                    modifier = Modifier
                        .width(300.dp)
                        .height(80.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF45E1E1))
                ) {
                    Text(
                        "Settings",
                        fontSize = 24.sp,
                        letterSpacing = 3.sp,
                        fontWeight = FontWeight.Bold,
                        fontFamily = pixelFont
                    )
                }
            }
        }
    }


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
fun PauseScreen(onResume: () -> Unit, onReset: () -> Unit, onMainMenu: () -> Unit) {
    val pixelFont = FontFamily(Font(R.font.press_start_2p_regular))

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xFF1A88EF))
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                "PAUSED",
                style = TextStyle(
                    fontSize = 40.sp,
                    letterSpacing = 4.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = pixelFont
                ),
                color = Color.White
            )

            Spacer(modifier = Modifier.height(80.dp))

            Button(
                onClick = onResume,
                modifier = Modifier
                    .width(280.dp)
                    .height(60.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF45E1E1))
            ) {
                Text(
                    "Resume",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = pixelFont,
                    color = Color.Black
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = onReset,
                modifier = Modifier
                    .width(280.dp)
                    .height(60.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF45E1E1))
            ) {
                Text(
                    "Reset Quiz",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = pixelFont,
                    color = Color.Black
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = onMainMenu,
                modifier = Modifier
                    .width(280.dp)
                    .height(60.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF45E1E1))
            ) {
                Text(
                    "Main Menu",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = pixelFont,
                    color = Color.Black
                )
            }
        }
    }
}


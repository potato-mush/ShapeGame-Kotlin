package com.example.shapegame.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.shapegame.R

@Composable
fun ResultScreen(score: Int, totalQuestions: Int, onReturnToMenu: () -> Unit) {
    val pixelFont = FontFamily(Font(R.font.press_start_2p_regular))

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xFF1A88EF)),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.complete),
                contentDescription = "Complete",
                modifier = Modifier.size(200.dp)
            )

            Spacer(modifier = Modifier.height(32.dp))

            Text(
                "CONGRATULATIONS!",
                style = TextStyle(
                    fontSize = 20.sp,
                    letterSpacing = 4.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = pixelFont,
                    textAlign = TextAlign.Center
                ),
                color = Color.White
            )

            Spacer(modifier = Modifier.height(36.dp))

            Text(
                "Quiz Completed!",
                style = TextStyle(
                    fontSize = 18.sp,
                    letterSpacing = 3.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = pixelFont,
                    textAlign = TextAlign.Center
                ),
                color = Color.White
            )

            Spacer(modifier = Modifier.height(24.dp))

            Text(
                "Your Score: $score / $totalQuestions",
                style = TextStyle(
                    fontSize = 18.sp,
                    letterSpacing = 2.sp,
                    fontFamily = pixelFont,
                    textAlign = TextAlign.Center
                ),
                color = Color.White
            )

            Spacer(modifier = Modifier.height(48.dp))

            Button(
                onClick = onReturnToMenu,
                modifier = Modifier
                    .width(260.dp)
                    .height(50.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF45E1E1))
            ) {
                Text(
                    "Main Menu",
                    fontSize = 18.sp,
                    letterSpacing = 3.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = pixelFont,
                    color = Color.Black
                )
            }
        }
    }
}

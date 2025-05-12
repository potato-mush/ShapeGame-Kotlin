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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.shapegame.R

@Composable
fun LevelsScreen(onLevelSelected: (Int) -> Unit) {
    val pixelFont = FontFamily(Font(R.font.press_start_2p_regular))

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xFF1A88EF))
    ) {
        AnimatedShapes(screenState = "Levels")
        
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            // Back button at the top
            IconButton(
                onClick = { onLevelSelected(0) }, // 0 indicates return to main menu
                modifier = Modifier
                    .size(64.dp)
                    .padding(12.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.back),
                    contentDescription = "Back",
                    modifier = Modifier.size(48.dp)
                )
            }

            // Main content
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    "SELECT LEVEL",
                    style = TextStyle(
                        fontSize = 28.sp,
                        letterSpacing = 4.sp,
                        fontWeight = FontWeight.Bold,
                        fontFamily = pixelFont
                    ),
                    color = Color.White
                )

                Spacer(modifier = Modifier.height(80.dp))

                Button(
                    onClick = { onLevelSelected(1) },
                    modifier = Modifier
                        .width(300.dp)
                        .height(80.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF45E1E1))
                ) {
                    Text(
                        "Grade 1",
                        fontSize = 24.sp,
                        letterSpacing = 3.sp,
                        fontWeight = FontWeight.Bold,
                        fontFamily = pixelFont,
                        color = Color.Black
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))

                Button(
                    onClick = { onLevelSelected(2) },
                    modifier = Modifier
                        .width(300.dp)
                        .height(80.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF45E1E1))
                ) {
                    Text(
                        "Grade 2",
                        fontSize = 24.sp,
                        letterSpacing = 3.sp,
                        fontWeight = FontWeight.Bold,
                        fontFamily = pixelFont,
                        color = Color.Black
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))

                Button(
                    onClick = { onLevelSelected(3) },
                    modifier = Modifier
                        .width(300.dp)
                        .height(80.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF45E1E1))
                ) {
                    Text(
                        "Grade 3",
                        fontSize = 24.sp,
                        letterSpacing = 3.sp,
                        fontWeight = FontWeight.Bold,
                        fontFamily = pixelFont,
                        color = Color.Black
                    )
                }
            }
        }
    }
}

package com.example.shapegame.screens

import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.shapegame.R
import com.example.shapegame.data.PreferencesManager
import com.example.shapegame.audio.SoundManager

@Composable
fun SettingsScreen(onReturnToMenu: () -> Unit) {
    val context = LocalContext.current
    val preferencesManager = remember { PreferencesManager(context) }
    val soundManager = remember { SoundManager(context) }
    val pixelFont = FontFamily(Font(R.font.press_start_2p_regular))
    var volume by remember { mutableStateOf(preferencesManager.getVolume()) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xFF1A88EF))
    ) {
        AnimatedShapes(screenState = "Settings")
        
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            // Back button at the top
            IconButton(
                onClick = onReturnToMenu,
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
                    "Settings",
                    style = TextStyle(
                        fontSize = 40.sp,
                        letterSpacing = 4.sp,
                        fontWeight = FontWeight.Bold,
                        fontFamily = pixelFont
                    ),
                    color = Color.White
                )

                Spacer(modifier = Modifier.height(32.dp))

                // Volume Control
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 32.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        "Volume: ${(volume * 100).toInt()}%",
                        style = TextStyle(
                            fontSize = 20.sp,
                            fontFamily = pixelFont
                        ),
                        color = Color.White
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Slider(
                        value = volume,
                        onValueChange = { newVolume ->
                            volume = newVolume
                            preferencesManager.saveVolume(newVolume)
                            soundManager.updateVolume()
                        },
                        modifier = Modifier.fillMaxWidth(),
                        colors = SliderDefaults.colors(
                            thumbColor = Color.White,
                            activeTrackColor = Color.White,
                            inactiveTrackColor = Color.White.copy(alpha = 0.3f)
                        )
                    )
                }
            }
        }
    }
}

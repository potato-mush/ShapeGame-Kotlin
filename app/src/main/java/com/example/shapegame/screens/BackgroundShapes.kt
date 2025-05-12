package com.example.shapegame.screens

import androidx.compose.animation.core.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.shapegame.R
import kotlin.random.Random

@Composable
fun AnimatedShapes(screenState: String) {
    val configuration = LocalConfiguration.current
    val screenWidth = configuration.screenWidthDp
    val screenHeight = configuration.screenHeightDp

    val shapes = listOf(
        R.drawable.square,
        R.drawable.circle,
        R.drawable.triangle,
        R.drawable.star
    )

    Box(modifier = Modifier.fillMaxSize()) {
        shapes.forEachIndexed { index, shape ->
            AnimatedShape(
                shapeRes = shape,
                screenState = screenState,
                index = index,
                screenWidth = screenWidth,
                screenHeight = screenHeight
            )
        }
    }
}

@Composable
private fun AnimatedShape(
    shapeRes: Int,
    screenState: String,
    index: Int,
    screenWidth: Int,
    screenHeight: Int
) {
    val screenTransition = updateTransition(
        targetState = screenState,
        label = "shape_transition"
    )

    val fixedScale = when (index) {
        0 -> 1.5f
        1 -> 1.5f
        2 -> 1.5f
        3 -> 1.5f
        else -> 1.0f
    }

    val fixedRotation = when (index) {
        0 -> 65f
        1 -> 45f
        2 -> 45f
        3 -> 60f
        else -> 0f
    }

    val xOffset by screenTransition.animateFloat(
        transitionSpec = {
            spring(
                dampingRatio = Spring.DampingRatioLowBouncy,
                stiffness = Spring.StiffnessVeryLow
            )
        },
        label = "xOffset_animation",
        targetValueByState = { state ->
            when (state) {
                "MainMenu" -> when (index) {
                    0 -> screenWidth - 90f
                    1 -> 10f
                    2 -> 10f
                    3 -> screenWidth / 3f + 80f
                    else -> 0f
                }
                "Settings" -> when (index) {
                    0 -> screenWidth / 2f + 30f
                    1 -> 40f
                    2 -> 55f
                    3 -> screenWidth / 2f + 30f
                    else -> 0f
                }
                "Levels" -> when (index) {
                    0 -> screenWidth / 2f + 30f
                    1 -> 40f
                    2 -> 55f
                    3 -> screenWidth / 2f + 30f
                    else -> 0f
                }
                else -> 0f
            }
        }
    )

    val yOffset by screenTransition.animateFloat(
        transitionSpec = {
            spring(
                dampingRatio = Spring.DampingRatioLowBouncy,
                stiffness = Spring.StiffnessVeryLow
            )
        },
        label = "yOffset_animation",
        targetValueByState = { state ->
            when (state) {
                "MainMenu" -> when (index) {
                    0 -> screenHeight - 420f
                    1 -> screenHeight / 2f
                    2 -> screenHeight - 200f
                    3 -> screenHeight - 200f
                    else -> 0f
                }
                "Settings" -> when (index) {
                    0 -> screenHeight / 2f + 60f
                    1 -> screenHeight / 2f + 80f
                    2 -> screenHeight - 210f
                    3 -> screenHeight - 200f
                    else -> 0f
                }
                "Levels" -> when (index) {
                    0 -> screenHeight / 2f + 60f
                    1 -> screenHeight / 2f + 80f
                    2 -> screenHeight - 210f
                    3 -> screenHeight - 200f
                    else -> 0f
                }
                else -> 0f
            }
        }
    )

    Image(
        painter = painterResource(id = shapeRes),
        contentDescription = null,
        modifier = Modifier
            .offset(x = xOffset.dp, y = yOffset.dp)
            .size((100 * fixedScale).dp)
            .rotate(fixedRotation)
    )
}

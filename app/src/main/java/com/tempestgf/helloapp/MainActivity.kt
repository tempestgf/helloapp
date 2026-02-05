package com.tempestgf.helloapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.EaseOutQuart
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tempestgf.helloapp.ui.theme.HelloAppTheme
import kotlinx.coroutines.delay

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HelloAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding),
                        contentAlignment = Alignment.Center
                    ) {
                        AwwwardsHero()
                    }
                }
            }
        }
    }
}

@Composable
fun AwwwardsHero() {
    val alpha = remember { Animatable(0f) }
    val yOffset = remember { Animatable(30f) }

    LaunchedEffect(Unit) {
        delay(400)
        alpha.animateTo(1f, animationSpec = tween(1200, easing = EaseOutQuart))
    }
    LaunchedEffect(Unit) {
        delay(400)
        yOffset.animateTo(0f, animationSpec = tween(1200, easing = EaseOutQuart))
    }

    Column(
        modifier = Modifier
            .padding(horizontal = 40.dp)
            .alpha(alpha.value)
            .offset(y = yOffset.value.dp),
        horizontalAlignment = Alignment.Start
    ) {
        Text(
            text = "Hello",
            style = MaterialTheme.typography.displayLarge.copy(
                fontWeight = FontWeight.Thin,
                fontSize = 80.sp,
                letterSpacing = (-4).sp,
                lineHeight = 72.sp
            ),
            color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.8f)
        )
        Text(
            text = "World!",
            style = MaterialTheme.typography.displayLarge.copy(
                fontWeight = FontWeight.ExtraBold,
                fontSize = 80.sp,
                letterSpacing = (-5).sp,
                lineHeight = 72.sp
            ),
            color = MaterialTheme.colorScheme.primary
        )

        Spacer(modifier = Modifier.height(40.dp))

        // Minimalist accent line
        Surface(
            modifier = Modifier
                .width(48.dp)
                .height(1.dp),
            color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.4f)
        ) {}

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "AUTOR: TEMPESTGF",
            style = MaterialTheme.typography.labelSmall.copy(
                letterSpacing = 5.sp,
                fontWeight = FontWeight.Medium
            ),
            color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f)
        )
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFFFFFFF)
@Composable
fun AwwwardsPreview() {
    HelloAppTheme {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            AwwwardsHero()
        }
    }
}

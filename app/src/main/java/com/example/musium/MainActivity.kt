package com.example.musium

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.content.ContextCompat
import androidx.core.view.WindowCompat
import com.example.musium.ui.theme.MusiumTheme
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.view.ViewCompat
import com.google.accompanist.systemuicontroller.rememberSystemUiController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MusiumTheme {

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R){
                    window.insetsController?.hide(0)
                }
                WindowCompat.setDecorFitsSystemWindows(window,false)
                ViewCompat.setOnApplyWindowInsetsListener(window.decorView){
                    _, insets ->
                            insets
                }
                SplashScreen()
            }
        }
    }
}

@Composable
fun SplashScreen() {
    Surface(modifier = Modifier.fillMaxSize(),
        color = colorResource(id = R.color.splash_color)) {
        Image(
            painter = painterResource(R.drawable.splashscreen),
            contentDescription = null,
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color.Black)
        )

        Column(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally

        ) {
            Text(
                text = "Feel the beat",
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.bodyLarge,
                color = colorResource(id = R.color.white)

            )
            Text(
                text = "Emmerse yourself into the\nworld of music today",
                fontSize = 16.sp,
                style = MaterialTheme.typography.bodySmall,
                color = colorResource(R.color.grey),
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .padding(64.dp, 8.dp, 64.dp, 32.dp)

            )
            TextButton(
                onClick = {},
                modifier =
                Modifier
                    .padding(16.dp)
                    .width(220.dp)
                    .background(
                        color = colorResource(id = R.color.splash_color),
                        shape = RoundedCornerShape(24.dp)
                    ),
            colors = ButtonDefaults.textButtonColors(contentColor = Color.White)
            )
                {
                Text(
                    text = "Continue",
                    style = MaterialTheme.typography.bodyMedium,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Normal,
                )
            }
            Spacer(
                modifier = Modifier.height(48.dp))
        }

    }
}



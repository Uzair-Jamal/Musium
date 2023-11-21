package com.example.musium

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import android.widget.SearchView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.widget.Placeholder
import androidx.core.view.ViewCompat
import androidx.core.view.WindowCompat
import com.example.musium.ui.theme.MusiumTheme
import com.google.android.material.search.SearchBar

class Screen2 : ComponentActivity() {
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
                // A surface container using the 'background' color from the theme
                BackgroundColor()
            }
        }
    }
}

    @Composable
    fun BackgroundColor() {
        Surface(
            modifier = Modifier
                .fillMaxSize()
        ){
            Image(
                painter = painterResource(id = R.drawable.playlistscreen),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxSize()
                    .background(color = Color.Black)
                )
            welcomeText()
        }
    }

@Composable
fun welcomeText(){
    val textState = remember {
        mutableStateOf(TextFieldValue(""))
    }
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(32.dp, 64.dp, 0.dp, 24.dp)
    ) {

        Text(
            modifier = Modifier
                .padding(0.dp,8.dp),
            text = "Welcome back!",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White
            )

        Text(
            modifier = Modifier
                .padding(0.dp,0.dp,0.dp,24.dp),
            text = "What do you feel like today?",
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            color = colorResource(id = R.color.gray)
            )

        searchView(state = textState)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun searchView(
    state: MutableState<TextFieldValue>,
){
    TextField(
        value = state.value ,
        onValueChange = {
            value -> state.value = value
        },
        modifier = Modifier
            .padding(0.dp, 8.dp)
            .clip(RoundedCornerShape(12.dp))
            .background(color = colorResource(id = R.color.dark_gray)),
        placeholder = {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(4.dp)
            )
            {
                Icon(imageVector = Icons.Default.Search, contentDescription = null , Modifier.size(30.dp))
                Text(
                    text = "Search song, playlist, artist...",
                    color = Color.Gray,
                    fontSize = 14.sp
                )
            }
        },
        maxLines = 1,
        singleLine = true,
        textStyle = TextStyle(
            color = colorResource(id = R.color.dark_gray),
            fontSize = 18.sp
        )
    )
}

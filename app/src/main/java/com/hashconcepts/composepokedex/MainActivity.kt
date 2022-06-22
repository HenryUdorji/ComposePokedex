package com.hashconcepts.composepokedex

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.hashconcepts.composepokedex.presentation.components.ConnectivityStatus
import com.hashconcepts.composepokedex.presentation.navigation.Navigation
import com.hashconcepts.composepokedex.presentation.screens.PokedexViewModel
import com.hashconcepts.composepokedex.ui.theme.ComposePokedexTheme
import com.hashconcepts.composepokedex.ui.theme.colorPrimary
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposePokedexTheme {
                Navigation()
            }
        }
    }
}

package com.hashconcepts.composepokedex.presentation.screens.pokedex_detail

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.google.accompanist.systemuicontroller.SystemUiController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.hashconcepts.composepokedex.domain.model.Pokemon
import com.hashconcepts.composepokedex.presentation.components.ConnectivityStatus
import com.hashconcepts.composepokedex.ui.theme.colorPrimary

/**
 * @created 20/06/2022 - 9:30 AM
 * @project ComposePokedex
 * @author  ifechukwu.udorji
 */

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun DetailScreen(
    pokemon: Pokemon,
    systemUiController: SystemUiController,
    onNavigateBack: () -> Unit
) {

    SideEffect {
        systemUiController.setStatusBarColor(color = Color(pokemon.randomColor))
    }

    // A surface container using the 'background' color from the theme
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = {
                        Row(
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.fillMaxWidth().padding(end = 10.dp)
                        ) {
                            Text(
                                text = "Pokedex",
                                textAlign = TextAlign.Start,
                                style = MaterialTheme.typography.h1,
                            )
                            Text(
                                text = pokemon.getIdString(),
                                textAlign = TextAlign.End,
                                style = MaterialTheme.typography.h1,
                            )
                        }

                    },
                    backgroundColor = Color(pokemon.randomColor),
                    navigationIcon = {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = "Arrow back",
                            tint = Color.White,
                            modifier = Modifier.clickable {
                                onNavigateBack()
                            }
                        )
                    }
                )
            }
        ) {
            Column {
                ConnectivityStatus()
            }
        }
    }
}
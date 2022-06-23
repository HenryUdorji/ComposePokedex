package com.hashconcepts.composepokedex.presentation.screens.pokedex_list

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import coil.compose.rememberAsyncImagePainter
import com.google.accompanist.systemuicontroller.SystemUiController
import com.hashconcepts.composepokedex.domain.model.Pokemon
import com.hashconcepts.composepokedex.presentation.components.ConnectivityStatus
import com.hashconcepts.composepokedex.presentation.screens.PokedexViewModel
import com.hashconcepts.composepokedex.ui.theme.colorPrimary

/**
 * @created 20/06/2022 - 9:30 AM
 * @project ComposePokedex
 * @author  ifechukwu.udorji
 */

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PokedexListScreen(
    systemUiController: SystemUiController,
    onNavigateToDetailScreen: (Pokemon) -> Unit
) {
    val viewModel = hiltViewModel<PokedexViewModel>()
    val pokedexState = viewModel.pokedexScreenState.value

    SideEffect {
        systemUiController.setStatusBarColor(color = colorPrimary)
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
                        Text(
                            text = "Pokedex",
                            modifier = Modifier.fillMaxWidth(),
                            textAlign = TextAlign.Center,
                            style = MaterialTheme.typography.h1,
                        )
                    },
                    backgroundColor = colorPrimary
                )
            }
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    ConnectivityStatus()

                    if (pokedexState.pokedex.isNotEmpty()) {
                        LazyVerticalGrid(
                            horizontalArrangement = Arrangement.spacedBy(10.dp),
                            verticalArrangement = Arrangement.spacedBy(10.dp),
                            modifier = Modifier.padding(10.dp),
                            columns = GridCells.Fixed(2),
                            content = {
                                items(pokedexState.pokedex) { pokemon ->
                                    Box(
                                        contentAlignment = Alignment.Center,
                                        modifier = Modifier
                                            .clip(RoundedCornerShape(10.dp))
                                            .background(Color(pokemon.randomColor))
                                            .size(170.dp)
                                            .padding(10.dp)
                                            .clickable { onNavigateToDetailScreen.invoke(pokemon) }
                                    ) {
                                        Column(
                                            verticalArrangement = Arrangement.Center,
                                            horizontalAlignment = Alignment.CenterHorizontally,
                                            modifier = Modifier.fillMaxWidth()
                                        ) {
                                            Image(
                                                painter = rememberAsyncImagePainter(pokemon.img),
                                                contentDescription = "Pokemon",
                                                modifier = Modifier.fillMaxWidth().size(120.dp),
                                                alignment = Alignment.Center
                                            )
                                            Spacer(modifier = Modifier.height(5.dp))
                                            Text(
                                                text = pokemon.name,
                                                style = MaterialTheme.typography.body1,
                                                color = Color.White,
                                                modifier = Modifier.fillMaxWidth(),
                                                textAlign = TextAlign.Center
                                            )
                                        }
                                    }
                                }
                            })
                    }

                }

                if (pokedexState.isLoading) {
                    CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
                }

                if (pokedexState.error.isNotBlank()) {
                    Text(
                        text = pokedexState.error,
                        color = MaterialTheme.colors.error,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 20.dp)
                            .align(Alignment.Center)
                    )
                }
            }
        }
    }
}
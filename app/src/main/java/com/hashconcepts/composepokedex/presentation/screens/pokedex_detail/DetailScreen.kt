package com.hashconcepts.composepokedex.presentation.screens.pokedex_detail

import android.annotation.SuppressLint
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.google.accompanist.flowlayout.FlowMainAxisAlignment
import com.google.accompanist.flowlayout.FlowRow
import com.google.accompanist.systemuicontroller.SystemUiController
import com.hashconcepts.composepokedex.domain.model.Pokemon
import com.hashconcepts.composepokedex.presentation.components.ConnectivityStatus
import com.hashconcepts.composepokedex.ui.theme.bug
import com.hashconcepts.composepokedex.ui.theme.colorPrimary
import com.hashconcepts.composepokedex.ui.theme.gray
import com.hashconcepts.composepokedex.utils.UtilMethods

/**
 * @created 20/06/2022 - 9:30 AM
 * @project ComposePokedex
 * @author  ifechukwu.udorji
 */

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
        Column(modifier = Modifier.fillMaxSize()) {
            ConnectivityStatus()

            TopBarSection(pokemon = pokemon) {
                onNavigateBack()
            }

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = pokemon.name,
                style = MaterialTheme.typography.h1,
                fontSize = 25.sp,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(15.dp))
            WeightAndHeightSection(pokemon)

            if (pokemon.type.isNotEmpty()) {
                Spacer(modifier = Modifier.height(20.dp))
                TypeSection(pokemon.type)
            }

            if (pokemon.weaknesses.isNotEmpty()) {
                Spacer(modifier = Modifier.height(20.dp))
                WeaknessSection(pokemon.weaknesses)
            }
        }
    }
}

@Composable
fun WeaknessSection(weaknesses: List<String>) {

    Text(
        text = "Weaknesses",
        style = MaterialTheme.typography.h1,
        fontSize = 22.sp,
        modifier = Modifier.fillMaxWidth(),
        textAlign = TextAlign.Center
    )

    Spacer(modifier = Modifier.height(15.dp))

    FlowRow(
        modifier = Modifier.fillMaxWidth(),
        mainAxisSpacing = 10.dp,
        crossAxisSpacing = 10.dp,
        mainAxisAlignment = FlowMainAxisAlignment.Center
    ) {
        weaknesses.map { weakness ->
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .clip(RoundedCornerShape(20.dp))
                    .background(colorPrimary)
                    .padding(horizontal = 10.dp)
            ) {
                Text(
                    text = weakness,
                    style = MaterialTheme.typography.body1,
                    color = Color.White
                )
            }
        }
    }
}

@Composable
fun TypeSection(types: List<String>) {

    Text(
        text = "Types",
        style = MaterialTheme.typography.h1,
        fontSize = 22.sp,
        modifier = Modifier.fillMaxWidth(),
        textAlign = TextAlign.Center
    )

    Spacer(modifier = Modifier.height(15.dp))

    FlowRow(
        modifier = Modifier.fillMaxWidth(),
        mainAxisSpacing = 10.dp,
        crossAxisSpacing = 10.dp,
        mainAxisAlignment = FlowMainAxisAlignment.Center
    ) {
        types.map { type ->
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .clip(RoundedCornerShape(20.dp))
                    .background(bug)
                    .padding(horizontal = 10.dp)
            ) {
                Text(
                    text = type,
                    style = MaterialTheme.typography.body1,
                    color = Color.White
                )
            }
        }
    }
}

@Composable
fun WeightAndHeightSection(pokemon: Pokemon) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        Column {
            Text(
                text = pokemon.weight,
                style = MaterialTheme.typography.h1,
                fontSize = 22.sp,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(5.dp))
            Text(
                text = "Weight",
                style = MaterialTheme.typography.body1,
                textAlign = TextAlign.Center,
                color = gray
            )
        }
        //Height
        Column {
            Text(
                text = pokemon.height,
                style = MaterialTheme.typography.h1,
                fontSize = 22.sp,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(5.dp))
            Text(
                text = "Height",
                style = MaterialTheme.typography.body1,
                textAlign = TextAlign.Center,
                color = gray
            )
        }
    }
}


@Composable
fun TopBarSection(pokemon: Pokemon, onNavigateBack: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(230.dp)
            .clip(RoundedCornerShape(bottomEnd = 35.dp, bottomStart = 35.dp))
            .background(Color(pokemon.randomColor))
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
        ) {
            Icon(
                imageVector = Icons.Filled.ArrowBack,
                contentDescription = "Arrow back",
                tint = Color.White,
                modifier = Modifier.clickable {
                    onNavigateBack()
                }
            )
            Spacer(modifier = Modifier.width(20.dp))
            Text(
                text = "Pokedex",
                textAlign = TextAlign.Start,
                style = MaterialTheme.typography.h1,
                modifier = Modifier.weight(1f)
            )
            Text(
                text = pokemon.getIdString(),
                textAlign = TextAlign.End,
                style = MaterialTheme.typography.h1,
            )
        }
        Spacer(modifier = Modifier.height(20.dp))
        Image(
            painter = rememberAsyncImagePainter(model = pokemon.img),
            contentDescription = "pokemon",
            modifier = Modifier
                .size(200.dp)
                .fillMaxWidth()
                .align(Alignment.Center),
            alignment = Alignment.Center
        )
    }
}
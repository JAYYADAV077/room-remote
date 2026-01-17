package com.example.pratice.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun JokeScreen(viewModel: JokesViewModel) {

    val jokes by viewModel.jokes.collectAsState(initial = emptyList())


    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {


        Spacer(modifier = Modifier.height(126.dp))


        Button(onClick = { viewModel.loadJokes() }) {}

        Spacer(modifier = Modifier.height(12.dp))


        LazyColumn(
            contentPadding = PaddingValues(16.dp)
        ) {
            items(jokes) { joke ->
                JokeListUi(
                    setup = joke.setup,
                    punchline = joke.punchline
                )
            }
        }


    }

}



@Composable
fun JokeListUi(
    modifier: Modifier = Modifier,
    setup: String = "",
    punchline: String = ""
) {
    Box(
        modifier = Modifier
            .padding(10.dp)
            .clip(shape = RoundedCornerShape(10.dp))
            .fillMaxWidth()
            .background(color = Color.Red)
            .padding(10.dp)


    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(setup)

            Spacer(modifier = modifier.height(10.dp))

            Text(punchline)
        }
    }
}
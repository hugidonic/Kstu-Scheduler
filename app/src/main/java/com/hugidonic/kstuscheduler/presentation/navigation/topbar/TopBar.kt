package com.hugidonic.kstuscheduler.presentation.navigation.topbar
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.style.TextAlign
import androidx.navigation.NavController

@Composable
fun TopBar(
    navController: NavController
) {
    TopAppBar(
        backgroundColor = MaterialTheme.colors.surface,
        navigationIcon = {
            IconButton(onClick = {
                navController.popBackStack()
            }) {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = "Вернуться назад"
                )
            }
        },
        title = {
            Text(
                text = "О дисциплине",
                textAlign = TextAlign.Center,

                style = MaterialTheme.typography.h2
            )
        },
    )
}

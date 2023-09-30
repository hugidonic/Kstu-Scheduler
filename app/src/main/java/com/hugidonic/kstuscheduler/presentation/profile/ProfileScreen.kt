package com.hugidonic.kstuscheduler.presentation.profile

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun ProfileScreen(
    state: ProfileState = ProfileState(),
    actions: ProfileActions = ProfileActions()
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Text(text = "Profile screen", style = MaterialTheme.typography.h1)
    }
}

@Composable
@Preview(name = "Profile")
private fun ProfileScreenPreview() {
    ProfileScreen()
}


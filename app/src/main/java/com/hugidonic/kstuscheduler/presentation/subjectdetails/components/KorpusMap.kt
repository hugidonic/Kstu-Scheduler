package com.hugidonic.kstuscheduler.presentation.subjectdetails.components

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun KorpusMap(
    modifier: Modifier = Modifier
) {
    Box(modifier = modifier) {
        Text(text = "KorpusMap")
    }
}

@Preview(name = "KorpusMap")
@Composable
private fun PreviewKorpusMap() {
    KorpusMap()
}
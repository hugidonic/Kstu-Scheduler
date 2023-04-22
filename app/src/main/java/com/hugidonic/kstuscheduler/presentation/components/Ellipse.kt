package com.hugidonic.kstuscheduler.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.hugidonic.kstuscheduler.R

@Composable
fun EllipseImage(
	isActive: Boolean = false,
) {
	val activeResId = if (isActive) R.drawable.active_ellipse else R.drawable.ellipse
	val size = if (isActive) 20.dp else 12.dp
	val endPadding = if (isActive) 0.dp else 4.dp


	Image(
		painter = painterResource(id=activeResId),
		contentDescription = null,
		modifier = Modifier.padding(end=endPadding).size(size),
		contentScale = ContentScale.Fit,
	)
}
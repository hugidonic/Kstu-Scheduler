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
	modifier: Modifier = Modifier,
	isActive: Boolean = false,
) {
	val activeResId = if (isActive) R.drawable.active_ellipse else R.drawable.ellipse

	Image(
		painter = painterResource(id=activeResId),
		contentDescription = null,
		modifier = modifier,
		contentScale = ContentScale.Fit,
	)
}
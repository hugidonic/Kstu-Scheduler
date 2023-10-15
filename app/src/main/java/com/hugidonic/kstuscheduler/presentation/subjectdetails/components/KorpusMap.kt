package com.hugidonic.kstuscheduler.presentation.subjectdetails.components

import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.SubcomposeAsyncImage
import coil.request.ImageRequest
import com.hugidonic.domain.models.KorpusModel
import com.hugidonic.kstuscheduler.presentation.utils.Constants


@Composable
fun KorpusMap(
    modifier: Modifier = Modifier,
    korpus: String,
) {
    val MAPS_API_BASE_URL = "https://static-maps.yandex.ru/v1?"
    val MAPS_API_KEY = "d437690f-e0ef-4794-bf61-b26de7b6272b"

    // TODO: Make up another solution for this
    val currentKorpus: KorpusModel = Constants.KORPUS_ll[korpus] ?: KorpusModel(55.794710, 49.138044)
    val ll = currentKorpus.getMap()
    val width = 375
    val height = 210
    val size = "$width,$height"
    val z = 16
    val pt = "${ll},pm2rdl"
    val URL = "${MAPS_API_BASE_URL}ll=${ll}&size=${size}&z=${z}&pt=${pt}&apikey=${MAPS_API_KEY}"

    Box() {
        SubcomposeAsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(URL)
                .crossfade(true)
                .build(),
            loading = {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(210.dp),
                    contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator(
                        color = MaterialTheme.colorScheme.primary,
                        strokeWidth = 8.dp,
                        strokeCap = StrokeCap.Round,
                        modifier = Modifier.size(100.dp)
                    )
                }
            },

            contentScale = ContentScale.Crop,
            contentDescription = "Korpus: $korpus",
            modifier = modifier
                .fillMaxWidth()
                .height(210.dp)
        )
        MakeRouteButton(modifier = Modifier.align(Alignment.BottomEnd), ll = currentKorpus.getYandexMapMarchrute())
    }
}

@Composable
fun MakeRouteButton(
    modifier: Modifier,
    ll: String
) {
    val activity = LocalContext.current as Activity
    val uri = Uri.parse("yandexmaps://maps.yandex.ru/?rtext=~${ll}&rtt=mt")
    val intent = Intent(Intent.ACTION_VIEW, uri)
    val bgColor = if (isSystemInDarkTheme()) MaterialTheme.colorScheme.secondary else MaterialTheme.colorScheme.primary

    Button(
        modifier = modifier
            .padding(10.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = bgColor
        ),
        contentPadding = PaddingValues(horizontal = 14.dp, vertical = 6.dp),
        shape = RoundedCornerShape(50),
        onClick = { activity.startActivity(intent) },
    ) {
        Text(
            text = "Проложить маршрут",
            modifier = Modifier,
            style = MaterialTheme.typography.labelLarge,
            color = MaterialTheme.colorScheme.onPrimary
        )
    }
}
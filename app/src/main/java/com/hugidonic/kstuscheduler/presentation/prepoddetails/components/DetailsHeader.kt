package com.hugidonic.kstuscheduler.presentation.prepoddetails.components

import android.content.res.Configuration
import android.graphics.Bitmap.Config
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.SubcomposeAsyncImage
import coil.request.ImageRequest
import com.hugidonic.domain.dummy.DummyData
import com.hugidonic.domain.models.PrepodDetailsModel
import com.hugidonic.kstuscheduler.presentation.ui.theme.AppTheme

@Composable
fun DetailsHeader(
    modifier: Modifier = Modifier,
    prepodDetails: PrepodDetailsModel = DummyData.prepodDetails
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.primary)
            .padding(16.dp)
    ) {
        Text(
            text = prepodDetails.info,
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.onPrimary,
            modifier = Modifier.fillMaxWidth(.6f)
        )
        Spacer(modifier = Modifier.fillMaxWidth(.1f))
        SubcomposeAsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(prepodDetails.imageUrl)
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
                        color = MaterialTheme.colorScheme.onPrimary,
                        strokeWidth = 8.dp,
                        strokeCap = StrokeCap.Round,
                        modifier = Modifier.size(100.dp)
                    )
                }
            },
            contentScale = ContentScale.FillWidth,
            contentDescription = "prepod details",
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Composable
private fun PreviewDetailsHeader() {
    AppTheme {
        Surface {
            DetailsHeader()
        }
    }
}

@Preview(name = "Light")
@Composable
private fun PreviewDetailsHeader_Light() {
    PreviewDetailsHeader()
}

@Preview(name = "Dark", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun PreviewDetailsHeader_Dark() {
    PreviewDetailsHeader()
}



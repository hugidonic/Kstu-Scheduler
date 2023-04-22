package com.hugidonic.kstuscheduler.presentation.ui.theme

import androidx.compose.material.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.hugidonic.kstuscheduler.R

val RobotoBold = FontFamily(Font(R.font.roboto_bold))
val RobotoRegular = FontFamily(Font(R.font.roboto_regular))
val RobotoMedium = FontFamily(Font(R.font.roboto_medium))

val Typography = Typography(
	body1 = TextStyle(
		fontFamily = RobotoBold,
		fontWeight = FontWeight.Bold,
		fontSize = 18.sp,
	),

	body2 = TextStyle(
		fontFamily = RobotoRegular,
		fontWeight = FontWeight.Bold,
		fontSize = 14.sp
	),

	subtitle1 = TextStyle(
		fontFamily = RobotoBold,
		fontWeight = FontWeight.Bold,
		fontSize = 12.sp
	),

	subtitle2 = TextStyle(
		fontFamily = RobotoRegular,
		fontWeight = FontWeight.Bold,
		fontSize = 12.sp
	),

	h1 = TextStyle(
		fontFamily = RobotoMedium,
		fontWeight = FontWeight.Medium,
		fontSize = 16.sp
	),

    button = TextStyle(
        fontFamily = RobotoRegular,
        fontWeight = FontWeight.W500,
        fontSize = 12.sp
    ),

    caption = TextStyle(
        fontFamily = RobotoMedium,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    )
)
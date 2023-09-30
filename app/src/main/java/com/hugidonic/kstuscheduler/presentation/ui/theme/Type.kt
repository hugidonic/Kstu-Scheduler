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
	h1 = TextStyle(
		fontFamily = RobotoBold,
		fontWeight = FontWeight.Bold,
		fontSize = 24.sp
	),

	h2 = TextStyle(
		fontFamily = RobotoBold,
		fontWeight = FontWeight.Bold,
		fontSize = 20.sp
	),

	h3 = TextStyle(
		fontFamily = RobotoBold,
		fontWeight = FontWeight.Bold,
		fontSize = 18.sp
	),

	h4 = TextStyle(
		fontFamily = RobotoBold,
		fontWeight = FontWeight.Bold,
		fontSize = 16.sp
	),

	h5 = TextStyle(
		fontFamily = RobotoBold,
		fontWeight = FontWeight.Bold,
		fontSize = 14.sp
	),

	h6 = TextStyle(
		fontFamily = RobotoBold,
		fontWeight = FontWeight.Bold,
		fontSize = 12.sp
	),

	body1 = TextStyle(
		fontFamily = RobotoMedium,
		fontWeight = FontWeight.Medium,
		fontSize = 16.sp
	),

	body2 = TextStyle(
		fontFamily = RobotoMedium,
		fontWeight = FontWeight.Medium,
		fontSize = 14.sp
	),

	subtitle1 = TextStyle(
		fontFamily = RobotoRegular,
		fontWeight = FontWeight.Normal,
		fontSize = 16.sp
	),
	subtitle2 = TextStyle(
		fontFamily = RobotoRegular,
		fontWeight = FontWeight.Normal,
		fontSize = 14.sp
	),
	caption = TextStyle(
		fontFamily = RobotoRegular,
		fontWeight = FontWeight.Normal,
		fontSize = 12.sp
	),
	button = TextStyle(
		fontFamily = RobotoMedium,
		fontWeight = FontWeight.Medium,
		fontSize = 12.sp
	),
)
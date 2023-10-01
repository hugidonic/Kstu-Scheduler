package com.hugidonic.kstuscheduler.presentation.ui.theme

import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.hugidonic.kstuscheduler.R

val RobotoBold = FontFamily(Font(R.font.roboto_bold))
val RobotoRegular = FontFamily(Font(R.font.roboto_regular))
val RobotoMedium = FontFamily(Font(R.font.roboto_medium))


val AppTypography = Typography(
	displayLarge = TextStyle(
		fontFamily = RobotoBold,
		fontWeight = FontWeight.Bold,
		fontSize = 24.sp
	),
	displayMedium = TextStyle(
		fontFamily = RobotoBold,
		fontWeight = FontWeight.Bold,
		fontSize = 22.sp
	),
	displaySmall = TextStyle(
		fontFamily = RobotoBold,
		fontWeight = FontWeight.Bold,
		fontSize = 20.sp
	),
	headlineLarge = TextStyle(
		fontFamily = RobotoBold,
		fontWeight = FontWeight.Bold,
		fontSize = 18.sp
	),
	headlineMedium = TextStyle(
		fontFamily = RobotoBold,
		fontWeight = FontWeight.Bold,
		fontSize = 16.sp
	),
	headlineSmall = TextStyle(
		fontFamily = RobotoBold,
		fontWeight = FontWeight.Bold,
		fontSize = 14.sp
	),



	titleLarge = TextStyle(
		fontFamily = RobotoMedium,
		fontWeight = FontWeight.Medium,
		fontSize = 18.sp
	),
	titleMedium = TextStyle(
		fontFamily = RobotoMedium,
		fontWeight = FontWeight.Medium,
		fontSize = 16.sp
	),
	titleSmall = TextStyle(
		fontFamily = RobotoMedium,
		fontWeight = FontWeight.Medium,
		fontSize = 14.sp
	),

	bodyLarge = TextStyle(
		fontFamily = RobotoRegular,
		fontWeight = FontWeight.Normal,
		fontSize = 18.sp
	),
	bodyMedium = TextStyle(
		fontFamily = RobotoRegular,
		fontWeight = FontWeight.Normal,
		fontSize = 16.sp
	),
	bodySmall = TextStyle(
		fontFamily = RobotoRegular,
		fontWeight = FontWeight.Normal,
		fontSize = 14.sp
	),
	labelLarge = TextStyle(
		fontFamily = RobotoRegular,
		fontWeight = FontWeight.Normal,
		fontSize = 12.sp
	),
	labelMedium = TextStyle(
		fontFamily = RobotoRegular,
		fontWeight = FontWeight.Normal,
		fontSize = 10.sp
	),
	labelSmall =  TextStyle(
		fontFamily = RobotoRegular,
		fontWeight = FontWeight.Normal,
		fontSize = 8.sp
	),
)
package com.hugidonic.kstuscheduler.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.hugidonic.kstuscheduler.presentation.navigation.AppNavGraph
import com.hugidonic.kstuscheduler.presentation.navigation.Screen
import com.hugidonic.kstuscheduler.presentation.navigation.topbar.TopBar
import com.hugidonic.kstuscheduler.presentation.ui.theme.AppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    val snackbarHostState = remember { SnackbarHostState() }

                    val navBackStackEntry by navController.currentBackStackEntryAsState()

                    var isTopBarVisible by rememberSaveable { (mutableStateOf(true)) }

                    // Control TopBar and BottomBar
                    when (navBackStackEntry?.destination?.route) {
                        Screen.SubjectDetails.route, Screen.PrepodDetails.route -> {
                            isTopBarVisible = true
                        }

                        else -> {
                            isTopBarVisible = false
                        }
                    }

                    Scaffold(
                        containerColor = MaterialTheme.colorScheme.background,
                        snackbarHost = {
                            SnackbarHost(snackbarHostState)
                        },
                        topBar = {
                            if (isTopBarVisible) {
                                TopBar(navController = navController)
                            }
                        },
                    ) { padding ->
                        AppNavGraph(
                            navHostController = navController,
                            padding = padding,
                            snackbarHostState = snackbarHostState
                        )
                    }
                }
            }
        }
    }
}

@Stable
@Composable
private fun NavHostController.shouldShowBottomNavigationAsState(): State<Boolean> {
    val shouldShowBottomNavigation = remember { mutableStateOf(false) }

    DisposableEffect(this) {
        val listener = NavController.OnDestinationChangedListener { _, destination, _ ->
            shouldShowBottomNavigation.value = destination.route != Screen.Splash.route
        }
        addOnDestinationChangedListener(listener)
        onDispose {
            removeOnDestinationChangedListener(listener)
        }
    }

    return shouldShowBottomNavigation
}





package com.example.composewithbottomnavbar.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.composewithbottomnavbar.domain.Destinations
import com.example.composewithbottomnavbar.presentation.theme.ComposeWithBottomNavBarTheme
import com.example.composewithbottomnavbar.presentation.widget.App
import com.example.composewithbottomnavbar.presentation.widget.BottomNavBar

class MainActivity : ComponentActivity() {

    private val viewModel: MainViewModel by viewModels()

    private fun onBackToHome(navController: NavHostController) {
        viewModel.onRouteSelected(Destinations.HomeScreen)
        navController.popBackStack()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            val selectedRoute by viewModel.routeState.collectAsState()
            ComposeWithBottomNavBarTheme {
                Scaffold(modifier = Modifier.fillMaxSize(),
                    bottomBar = {
                        BottomNavBar(
                            navController = navController,
                            selectedRoute = selectedRoute.route,
                            onClick = { route ->
                                viewModel.onRouteSelected(route)
                                navController.navigate(route) {
                                    popUpTo(navController.graph.findStartDestination().id) {
                                        saveState = true
                                    }
                                    launchSingleTop = true
                                    restoreState = true
                                }
                            })
                    }) { innerPadding ->
                    LaunchedEffect(key1 = selectedRoute.route) {
                        navController.navigate(selectedRoute.route)
                    }
                    App(innerPadding = innerPadding, navController = navController,
                        onBackProfileScreen = {
                            onBackToHome(navController)
                        },
                        onBackSettingsScreen = {
                            onBackToHome(navController)
                        },
                        onSettingsClick = {
                            viewModel.onRouteSelected(Destinations.SettingsScreen)
                        })
                }
            }
        }
    }
}

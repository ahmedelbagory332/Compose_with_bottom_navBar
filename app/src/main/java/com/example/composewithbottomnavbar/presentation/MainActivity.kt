package com.example.composewithbottomnavbar.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.composewithbottomnavbar.domain.Destinations
import com.example.composewithbottomnavbar.domain.navigateToRoute
import com.example.composewithbottomnavbar.presentation.theme.ComposeWithBottomNavBarTheme
import com.example.composewithbottomnavbar.presentation.widget.App
import com.example.composewithbottomnavbar.presentation.widget.BottomNavBar


class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            val currentBackStackEntry by navController.currentBackStackEntryAsState()
            val currentDestination = currentBackStackEntry?.destination?.route
            val nameForCurrentDestination = currentDestination?.substringAfterLast(".")

            ComposeWithBottomNavBarTheme {
                Scaffold(modifier = Modifier.fillMaxSize(),
                    bottomBar = {
                        BottomNavBar(
                            currentRoute = nameForCurrentDestination ?: "",
                            onClick = { route ->
                                if (nameForCurrentDestination != route.route) {
                                    navigateToRoute(navController, route)
                                }
                            })
                    }) { innerPadding ->
                    App(innerPadding = innerPadding, navController = navController,
                        onSettingsClick = {
                            navigateToRoute(navController, Destinations.SettingsScreen)
                        })
                }
            }
        }
    }
}